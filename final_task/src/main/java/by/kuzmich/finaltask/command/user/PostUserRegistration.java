package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class PostUserRegistration extends Command {

    private Builder<User> builder;
    private UserService service;
    private SessionHandler sessionHandler;

    public PostUserRegistration(Builder<User> builder, UserService service, SessionHandler sessionHandler) {
        this.builder = builder;
        this.service = service;
        this.sessionHandler = sessionHandler;
    }

    /**
     * Creates an new user object and saves it.
     */
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        User user = builder.build(req);
        service.add(user);
        sessionHandler.create(req, user);
        super.setRedirected(true);
        return PagePathList.NAME_LIST_REDIRECTED;
    }

}
