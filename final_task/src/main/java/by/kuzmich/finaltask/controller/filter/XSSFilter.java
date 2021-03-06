package by.kuzmich.finaltask.controller.filter;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class XSSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    /**
     * Wrap's request in the XSSRequestWrapper
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
    }

}