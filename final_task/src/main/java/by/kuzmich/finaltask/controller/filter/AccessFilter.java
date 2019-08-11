package by.kuzmich.finaltask.controller.filter;

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
