package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.bean.User;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter{
    private CookieHandler<User> cookieHandler = CookieHandlerFactory.getInstance().get();
    private SessionHandler sessionHandler = SessionHandlerFactory.getInstance().get();
    private String EMPTY_COOKIE_VALUE = "";
    private String REGISTRATION_PAGE_PATH = "/welcome.jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        String value = cookieHandler.getValue(httpRequest);
        if (EMPTY_COOKIE_VALUE.equals(value)){
            req.getServletContext().getRequestDispatcher(REGISTRATION_PAGE_PATH).forward(req, resp);
            httpResponse.sendRedirect(httpRequest.getContextPath() + REGISTRATION_PAGE_PATH);
        }
        chain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
