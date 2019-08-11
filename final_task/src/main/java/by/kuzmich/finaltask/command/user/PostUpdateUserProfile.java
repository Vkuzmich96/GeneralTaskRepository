package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostUpdateUserProfile extends Command {

    private UserService userService;
    private SessionHandler sessionHandler;

    public PostUpdateUserProfile(UserService userService, SessionHandler sessionHandler) {
        this.userService = userService;
        this.sessionHandler = sessionHandler;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String kind  = req.getParameter(KeyWordsList.PROFILE_ACTION_KIND);
        switch (kind){
            case KeyWordsList.NAME:
                updateName(req);
                break;
            case KeyWordsList.ROLE:
                updateRole(req);
                break;
            case KeyWordsList.PASSWORD:
                updatePassword(req);
                break;
            case KeyWordsList.ADDRESS:
                updateAddress(req);
                break;
            case KeyWordsList.PHONE:
                updatePhone(req);
                break;
        }
        super.setRedirected(true);
        return PagePathList.USER_PROFILE_REDIRECTED;
    }

    private User getUser(HttpServletRequest req) throws ServiceException {
        String login = sessionHandler.getLogin(req);
        return userService.get(login);
    }

    private String getValue(HttpServletRequest req){
        return req.getParameter(KeyWordsList.VALUE);
    }

    private void setUser(User user) throws ServiceException {
        userService.update(user);
    }

    private void updateName(HttpServletRequest req) throws ServiceException {
        User user = getUser(req);
        String name = getValue(req);
        user.setName(name);
        setUser(user);
    }

    private void updateRole(HttpServletRequest req) throws ServiceException {
        User user = getUser(req);
        Role role;
        String roleParameter = getValue(req);
        switch (roleParameter){
            default:
                role =null;
                break;
            case KeyWordsList.USER:
                role = Role.USER;
                break;
            case KeyWordsList.ADMIN:
                role = Role.ADMIN;
                break;
            case KeyWordsList.LAWER:
                role = Role.LAWER;
                break;
        }
        user.setRole(role);
        setUser(user);
    }
    private void updatePassword(HttpServletRequest req) throws ServiceException {
        User user = getUser(req);
        String password = getValue(req);
        user.setPassword(password);
        setUser(user);
    }
    private void updateAddress(HttpServletRequest req) throws ServiceException {
        User user = getUser(req);
        String address = getValue(req);
        user.setAddress(address);
        setUser(user);
    }
    private void updatePhone(HttpServletRequest req) throws ServiceException {
        User user = getUser(req);
        String phone = getValue(req);
        user.setNumber(Long.valueOf(phone));
        setUser(user);
    }
}
