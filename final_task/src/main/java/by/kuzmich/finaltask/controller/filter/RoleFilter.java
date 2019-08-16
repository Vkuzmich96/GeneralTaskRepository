package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.command.CommandKind;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoleFilter  implements Filter{
    private static final String GENERAL_PAGE = "/pages/list.html";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Checks does user has a rights to get access for requested page
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Role role = (Role) req.getSession().getAttribute(KeyWordsList.ROLE);
        if(!Role.LAWER.equals(role)) {
            resp.sendRedirect(req.getContextPath() + GENERAL_PAGE);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
