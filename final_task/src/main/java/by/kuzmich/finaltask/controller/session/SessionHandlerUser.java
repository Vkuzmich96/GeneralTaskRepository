package by.kuzmich.finaltask.controller.session;

import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.controller.KeyWordsList;

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
            }
    }

    public String getRole(HttpServletRequest req){
        return (String) req.getAttribute(KeyWordsList.ROLE);
    }

    public String getLogin(HttpServletRequest req){
        return (String) req.getAttribute(KeyWordsList.LOGIN);
    }

    public boolean isExists(HttpServletRequest req){
        return req.getSession(false).getAttributeNames().hasMoreElements();
    }
}
