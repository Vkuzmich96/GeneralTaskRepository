package by.kuzmich.finaltask.controller.builder;

import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;

import javax.servlet.http.HttpServletRequest;

public class UserBuilderEnter implements Builder<User> {

    @Override
    public User build(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        return new User(
                UserDefaultValues.DEFAULT_ID,
                email,
                password,
                UserDefaultValues.DEFAULT_ROLE,
                UserDefaultValues.DEFAULT_NAME,
                UserDefaultValues.DEFAULT_ADDRESS,
                UserDefaultValues.DEFAULT_NUMBER
        );

    }
}
