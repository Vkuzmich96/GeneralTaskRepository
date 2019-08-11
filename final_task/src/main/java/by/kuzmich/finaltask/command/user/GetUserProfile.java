package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserProfile extends Command {
    private SessionHandler sessionHandler;
    private UserService userService;

    public GetUserProfile(SessionHandler sessionHandler, UserService userService) {
        this.sessionHandler = sessionHandler;
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String login = sessionHandler.getLogin(req);
        User user = userService.get(login);
        req.setAttribute(KeyWordsList.USER, user);
        return PagePathList.USER_PROFILE;
    }
}
