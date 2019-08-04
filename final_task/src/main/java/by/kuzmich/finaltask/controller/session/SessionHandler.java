package by.kuzmich.finaltask.controller.session;

import by.kuzmich.finaltask.bean.User;

import javax.servlet.http.HttpServletRequest;

public interface SessionHandler {
    void create(HttpServletRequest req, User user);
    String getRole(HttpServletRequest req);
    String getLogin(HttpServletRequest req);
    int getGraphId (HttpServletRequest req);
    boolean isExists(HttpServletRequest req);
    void setGraphId (HttpServletRequest req, int id);
    void setActionId(HttpServletRequest req, int childId);
    void incrementStep(HttpServletRequest req);
    void changeActualActionId(HttpServletRequest req);
    void close (HttpServletRequest req);
    void setActualActionId(HttpServletRequest req, int actualId);
}
