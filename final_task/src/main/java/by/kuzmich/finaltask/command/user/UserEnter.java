package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.builder.Builder;
import by.kuzmich.finaltask.service.LawMapNameService;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UserEnter extends Command {

    private Builder<User> builder;
    private UserService userService;
    private LawMapNameService nameService;

    public UserEnter(Builder<User> builder, UserService userService, LawMapNameService nameService) {
        this.builder = builder;
        this.userService = userService;
        this.nameService = nameService;
    }

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        User user = builder.build(req);
            if (userService.checkPassword(user)){
                req.setAttribute("maps", nameService.getAll());
            } else {
                req.setAttribute("massage", "wrong login or password try again");
                return PagePathList.ENTER;
            }
            super.setRedirected(true);
        return PagePathList.NAME_LIST;
    }
}
