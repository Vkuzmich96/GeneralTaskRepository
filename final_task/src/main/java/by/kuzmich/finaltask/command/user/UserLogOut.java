package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UserLogOut extends Command {
    private CookieHandler cookieHandler;
    private SessionHandler sessionHandler;

    public UserLogOut(CookieHandler cookieHandler, SessionHandler sessionHandler) {
        this.cookieHandler = cookieHandler;
        this.sessionHandler = sessionHandler;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp){
        cookieHandler.delete(req, resp);
        sessionHandler.close(req);
        super.setRedirected(true);
        return PagePathList.REGISTRATION;
    }
}
