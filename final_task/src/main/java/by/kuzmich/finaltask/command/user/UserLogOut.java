package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UserLogOut extends Command {
    private CookieHandler cookieHandler;

    public UserLogOut(CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
    }

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        cookieHandler.delete(req, resp);
        super.setRedirected(true);
        return PagePathList.REGISTRATION;
    }
}
