package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.LawMapNameService;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class PostUserLogIn extends Command {
    private final static String
    WRONG_LOGIN_OR_PASSWORD_MASSAGE = "Wrong login or password try again",
    WRONG_LOGIN_OR_PASSWORD_NAME = "wrongLoginOrPassword";

    private Builder<User> builder;
    private CookieHandler<User> cookieHandler;


    public PostUserLogIn(Builder<User> builder, CookieHandler<User> cookieHandler) {
        this.builder = builder;
        this.cookieHandler = cookieHandler;
    }

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = builder.build(req);
        cookieHandler.add(resp, user);
        super.setRedirected(true);
        return PagePathList.NAME_LIST_REDIRECTED;
    }
}
