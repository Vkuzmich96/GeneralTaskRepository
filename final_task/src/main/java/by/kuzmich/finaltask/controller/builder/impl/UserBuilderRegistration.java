package by.kuzmich.finaltask.controller.builder.impl;

import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.controller.builder.Builder;
import by.kuzmich.finaltask.controller.builder.UserDefaultValues;

import javax.servlet.http.HttpServletRequest;

public class UserBuilderRegistration implements Builder<User> {

    @Override
    public User build(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String number = req.getParameter("number");
        return new User(
                UserDefaultValues.DEFAULT_ID,
                email,
                password,
                UserDefaultValues.DEFAULT_ROLE,
                name,
                address,
                Long.valueOf(number)
        );

    }
}
