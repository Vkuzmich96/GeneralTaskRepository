package by.kuzmich.finaltask.controller.session;

import by.kuzmich.finaltask.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionHandlerUser implements SessionHandler {

    private String LOGIN = "login";
    private String ROLE = "role";


    public void create(HttpServletRequest req, User user){
        HttpSession session = req.getSession(false);
        session.setAttribute(LOGIN, user.getEmail());
        session.setAttribute(ROLE, user.getRole());
    }

    public String getRole(HttpServletRequest req){
        return (String) req.getAttribute(ROLE);
    }

    public String getLogin(HttpServletRequest req){
        return (String) req.getAttribute(LOGIN);
    }

    public boolean isExists(HttpServletRequest req){
        return req.getSession(false).getAttributeNames().hasMoreElements();
    }
}
