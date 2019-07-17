package by.kuzmich.finaltask.action.user;

import by.kuzmich.finaltask.action.Command;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.controller.builder.Builder;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserEnter implements Command {

    private Builder<User> builder;
    private UserService service;

    public UserEnter(Builder<User> builder, UserService service) {
        this.builder = builder;
        this.service = service;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = builder.build(req);
        try {
            boolean isEquals = service.checkPassword(user);
            if (isEquals){
                resp.sendRedirect(req.getContextPath() + "/pages/work.jsp");
            }else {
                req.setAttribute("massage", "wrong login or password try again");
                req.getServletContext().getRequestDispatcher("/pages/enter.jsp").forward(req, resp);
            }
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
