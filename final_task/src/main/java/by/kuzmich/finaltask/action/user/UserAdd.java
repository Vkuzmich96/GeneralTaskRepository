package by.kuzmich.finaltask.action.user;

import by.kuzmich.finaltask.action.Command;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.controller.builder.Builder;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UserAdd extends Command {

    private Builder<User> builder;
    private UserService service;

    public UserAdd(Builder<User> builder, UserService service) {
        this.builder = builder;
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        User user = builder.build(req);
            service.add(user);
            super.setRedirected(true);
        return "/pages/enter.jsp";
    }
}
