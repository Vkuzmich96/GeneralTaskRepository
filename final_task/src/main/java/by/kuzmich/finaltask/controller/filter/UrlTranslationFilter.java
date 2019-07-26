package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.command.CommandKind;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UrlTranslationFilter implements Filter{
    private static Map<String, CommandKind> map = new HashMap<>();
    static {
        map.put("/registration.html", CommandKind.ADD_USER);
        map.put("/enter.html", CommandKind.ENTER_USER);
        map.put("/lawmap.html", CommandKind.MAP_GET);
        map.put("/command.html", CommandKind.ACTION_GET);
        map.put("/logout.html", CommandKind.LOG_OUT);
        map.put("/lawermenu.html", CommandKind.GET_LAWER_MENU);
        map.put("/addMaterial.html", CommandKind.ADD_MATERIAL);
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
            httpRequest.setAttribute("command", kind);
            chain.doFilter(httpRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
