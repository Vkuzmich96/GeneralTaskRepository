package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.CommandFactory;
import by.kuzmich.finaltask.command.CommandKind;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.controller.cookie.CookieHandlerFactory;
import by.kuzmich.finaltask.controller.cookie.CookieHandlerUserAccess;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.controller.session.SessionHandlerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AccessFilter implements Filter{
    private CookieHandler<User> cookieHandler = CookieHandlerFactory.getInstance().get();
    private SessionHandler sessionHandler = SessionHandlerFactory.getInstance().get();
    private Command createSession = CommandFactory.getInstance().get(CommandKind.CREATE_SESSION);
    private String EMPTY_COOKIE_VALUE = "";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        String actualCookieValue = cookieHandler.getValue(httpRequest);
        if (EMPTY_COOKIE_VALUE.equals(actualCookieValue)){
            httpResponse.sendRedirect(httpRequest.getContextPath() + PagePathList.REGISTRATION);
        }else {
            if(!sessionHandler.isExists(httpRequest)){
                try {
                    createSession.execute(httpRequest, httpResponse);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            chain.doFilter(httpRequest, httpResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
