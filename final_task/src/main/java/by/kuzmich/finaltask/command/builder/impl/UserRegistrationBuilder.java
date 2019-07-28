package by.kuzmich.finaltask.command.builder.impl;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.command.builder.DefaultValues;

import javax.servlet.http.HttpServletRequest;

public class UserRegistrationBuilder implements Builder<User> {

    @Override
    public User build(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String number = req.getParameter("number");
        return new User(
                DefaultValues.DEFAULT_ID,
                email,
                password,
                DefaultValues.DEFAULT_ROLE,
                name,
                address,
                Long.valueOf(number)
        );

    }
}
