package by.kuzmich.finaltask.controller.session;

import by.kuzmich.finaltask.bean.User;

import javax.servlet.http.HttpServletRequest;

public interface SessionHandler {
    void create(HttpServletRequest req, User user);
    String getRole(HttpServletRequest req);
    String getLogin(HttpServletRequest req);
    boolean isExists(HttpServletRequest req);
}
