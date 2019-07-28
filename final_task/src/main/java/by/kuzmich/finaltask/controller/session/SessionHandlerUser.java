package by.kuzmich.finaltask.controller.session;

import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.KeyWordsList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionHandlerUser implements SessionHandler {

    public void create(HttpServletRequest req, User user){
            HttpSession session = req.getSession(false);
            session.setAttribute(KeyWordsList.LOGIN, user.getEmail());

            Role userRole = user.getRole();
            session.setAttribute(KeyWordsList.ROLE, user.getRole());

            if (Role.LAWER == userRole){
                session.setAttribute(KeyWordsList.GRAPH_ID, null);
                session.setAttribute(KeyWordsList.STEP, KeyWordsList.FIRST_STEP);
                session.setAttribute(KeyWordsList.ACTION_ID, null);
                session.setAttribute(KeyWordsList.ACTUAL_ACTION_ID, null);
            }
    }

    public String getRole(HttpServletRequest req){
        return (String) req.getSession().getAttribute(KeyWordsList.ROLE);
    }

    public String getLogin(HttpServletRequest req){
        return (String) req.getSession().getAttribute(KeyWordsList.LOGIN);
    }

    public int getGraphId (HttpServletRequest req) {
        return (Integer) req.getSession().getAttribute(KeyWordsList.GRAPH_ID);
    }

    public boolean isExists(HttpServletRequest req){
        return req.getSession(false).getAttributeNames().hasMoreElements();
    }

    public void setGraphId (HttpServletRequest req, int id){
        req.getSession().setAttribute(KeyWordsList.GRAPH_ID, id);
    }


    public void setActionId(HttpServletRequest req, int childId) {
        req.getSession().setAttribute(KeyWordsList.ACTION_ID, childId);
    }

    public void changeActualActionId(HttpServletRequest req) {
        Integer id = (Integer) req.getSession().getAttribute(KeyWordsList.ACTION_ID);
        req.getSession().setAttribute(KeyWordsList.ACTUAL_ACTION_ID, id);
    }

    public void incrementStep(HttpServletRequest req){
        Integer step = (Integer) req.getSession().getAttribute(KeyWordsList.STEP);
        step = ++step;
        req.getSession().setAttribute(KeyWordsList.STEP, step);
    }
}
