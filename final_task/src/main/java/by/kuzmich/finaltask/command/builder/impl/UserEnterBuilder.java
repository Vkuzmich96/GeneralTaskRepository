package by.kuzmich.finaltask.command.builder.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.command.builder.DefaultValues;

import javax.servlet.http.HttpServletRequest;

public class UserEnterBuilder implements Builder<User> {

    @Override
    public User build(HttpServletRequest req) {
        String email = req.getParameter(KeyWordsList.EMAIL);
        String password = req.getParameter(KeyWordsList.PASSWORD);
        return new User(
                DefaultValues.DEFAULT_ID,
                email,
                password,
                DefaultValues.DEFAULT_ROLE,
                DefaultValues.DEFAULT_NAME,
                DefaultValues.DEFAULT_ADDRESS,
                DefaultValues.DEFAULT_NUMBER
        );
    }
}
