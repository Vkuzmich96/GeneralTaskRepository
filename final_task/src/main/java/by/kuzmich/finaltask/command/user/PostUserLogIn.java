package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostUserLogIn extends Command {
    private SessionHandler sessionHandler;
    private UserService userService;

    public PostUserLogIn(SessionHandler sessionHandler, UserService userService) {
        this.sessionHandler = sessionHandler;
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String email = req.getParameter(KeyWordsList.EMAIL);
        User user = userService.get(email);
        sessionHandler.create(req, user);
        super.setRedirected(true);
        return PagePathList.NAME_LIST_REDIRECTED;
    }
}
