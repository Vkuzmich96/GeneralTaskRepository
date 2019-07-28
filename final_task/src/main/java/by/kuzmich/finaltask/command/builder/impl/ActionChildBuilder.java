package by.kuzmich.finaltask.command.builder.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.command.builder.DefaultValues;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class ActionChildBuilder implements Builder<Action> {
    private UserService userService;
    private CookieHandler cookieHandler;

    public ActionChildBuilder(UserService userService, CookieHandler cookieHandler) {
        this.userService = userService;
        this.cookieHandler = cookieHandler;
    }

    @Override
    public Action build(HttpServletRequest req) {
        String login = cookieHandler.getValue(req);
        User user = null;
        try {
            user = userService.get(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String name = req.getParameter(KeyWordsList.NAME);
        String instructions = req.getParameter(KeyWordsList.INSTRUCTIONS);
        return new Action(DefaultValues.DEFAULT_ID, name, instructions,null, user);
    }
}
