package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.KeyWordsList;
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
        map.put("/action.html", CommandKind.ACTION_GET);
        map.put("/logout.html", CommandKind.LOG_OUT);
        map.put("/lawyerMenu.html", CommandKind.GET_LAWER_MENU);
        map.put("/addMaterial.html", CommandKind.ADD_MATERIAL);
        map.put("/pages/list.html", CommandKind.GET_ALL_MAP_NAMES);
        map.put("/addMap.html", CommandKind.POST_MAP_NAME);
        map.put("/addAction.html", CommandKind.POST_ACTION);
        map.put("/profile.html", CommandKind.GET_USER_PROFILE);
        map.put("/update.html", CommandKind.POST_UPDATE_USER_PROFILE);
        map.put("/continue.html", CommandKind.CONTINUE);
        map.put("/delete.html", CommandKind.DELETE);
        map.put("/release.html", CommandKind.REALISE);
        map.put("/updateActionMenu.html", CommandKind.GET_UPDATE_ACTION);
        map.put("/updateAction.html", CommandKind.POST_UPDATE_ACTION);
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
            httpRequest.setAttribute(KeyWordsList.COMMAND, kind);
            chain.doFilter(httpRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
