package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.controller.session.SessionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogOut extends Command {
    private SessionHandler sessionHandler;

    public UserLogOut(SessionHandler sessionHandler) {
        this.sessionHandler = sessionHandler;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp){
        sessionHandler.close(req);
        super.setRedirected(true);
        return PagePathList.REGISTRATION;
    }
}
