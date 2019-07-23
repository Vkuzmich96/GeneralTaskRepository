package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.builder.Builder;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UserAdd extends Command {

    private Builder<User> builder;
    private UserService service;
    private CookieHandler<User> cookieHandler;

    public UserAdd(Builder<User> builder, UserService service, CookieHandler<User> cookieHandler) {
        this.builder = builder;
        this.service = service;
        this.cookieHandler = cookieHandler;
    }

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        User user = builder.build(req);
            service.add(user);
            cookieHandler.add(resp, user);
            super.setRedirected(true);
        return PagePathList.ENTER;
    }

}
