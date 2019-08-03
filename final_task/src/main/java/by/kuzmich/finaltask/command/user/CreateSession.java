package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateSession extends Command {
    private UserService service;
    private SessionHandler sessionHandler;
    private CookieHandler<User> cookieHandler;

    public CreateSession(UserService service, SessionHandler sessionHandler, CookieHandler<User> cookieHandler) {
        this.service = service;
        this.sessionHandler = sessionHandler;
        this.cookieHandler = cookieHandler;
    }

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String login = cookieHandler.getValue(req);
        User user = service.get(login);
        sessionHandler.create(req, user);
        return PagePathList.GAP;
    }
}
