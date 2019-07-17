package by.kuzmich.finaltask.action.user;

import by.kuzmich.finaltask.action.Command;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.controller.builder.Builder;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserAdd implements Command {

    private Builder<User> builder;
    private UserService service;

    public UserAdd(Builder<User> builder, UserService service) {
        this.builder = builder;
        this.service = service;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = builder.build(req);
        try {
            service.add(user);
            resp.sendRedirect(req.getContextPath() + "/pages/enter.jsp");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
