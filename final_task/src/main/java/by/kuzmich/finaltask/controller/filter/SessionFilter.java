package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.CommandFactory;
import by.kuzmich.finaltask.command.CommandKind;
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

public class SessionFilter implements Filter {
    private SessionHandler sessionHandler = SessionHandlerFactory.getInstance().get();
    private Command createSession = CommandFactory.getInstance().get(CommandKind.CREATE_SESSION);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        if(!sessionHandler.isExists(httpRequest)){
            try {
                createSession.execute(httpRequest, httpResponse);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}