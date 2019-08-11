package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.controller.cookie.CookieHandlerFactory;

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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        HttpSession session = httpRequest.getSession(false);
        boolean notNull = session != null;
        boolean hasMore = session.getAttributeNames().hasMoreElements();
        if (notNull && hasMore){
            chain.doFilter(httpRequest, httpResponse);
        }else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + PagePathList.REGISTRATION);
        }
    }

    @Override
    public void destroy() {

    }
}
