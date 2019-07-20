package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.action.CommandKind;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UrlTranslationFilter implements Filter{
    private static Map<String, CommandKind> map = new HashMap<>();
    static {
        map.put("/registration.html", CommandKind.ADD_USER);
        map.put("/enter.html", CommandKind.ENTER_USER);
        map.put("/lawmap.html", CommandKind.MapGet);
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            String url = httpRequest.getRequestURI();
            CommandKind kind = map.get(url);
            httpRequest.setAttribute("action", kind);
            chain.doFilter(httpRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
