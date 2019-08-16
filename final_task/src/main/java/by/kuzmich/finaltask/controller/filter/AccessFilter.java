package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.PagePathList;

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

    @Override
    public void init(FilterConfig filterConfig) {
    }

    /**
     * Checks does the login is contained in the session, if not, redirects the user to the login page
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        HttpSession session = httpRequest.getSession(false);
        if (session != null && session.getAttribute(KeyWordsList.LOGIN) != null){
            chain.doFilter(httpRequest, httpResponse);
        }else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + PagePathList.REGISTRATION);
        }
    }

    @Override
    public void destroy() {

    }
}
