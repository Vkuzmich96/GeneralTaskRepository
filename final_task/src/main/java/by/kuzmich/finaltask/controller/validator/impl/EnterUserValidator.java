package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.controller.validator.Validator;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class EnterUserValidator extends Validator {
    private Builder<User> builder;
    private UserService userService;
    private static final String
    WRONG_LOGIN_OR_PASSWORD_MASSAGE = "Wrong login or password",
    WRONG_LOGIN_OR_PASSWORD_NAME = "wrongLoginOrPassword";

    public EnterUserValidator(Builder<User> builder, UserService userService) {
        this.builder = builder;
        this.userService = userService;
    }

    @Override
    public boolean isValid (HttpServletRequest req) throws ServiceException {
        String email = req.getParameter(KeyWordsList.EMAIL);
        putValidateParameterMap(KeyWordsList.EMAIL, email);
        String password = req.getParameter(KeyWordsList.PASSWORD);
        putValidateParameterMap(KeyWordsList.PASSWORD, password);
        return isParameterValid(email, EMAIL, WRONG_LOGIN_OR_PASSWORD_NAME, WRONG_LOGIN_OR_PASSWORD_MASSAGE) &
               isParameterValid(password, PASSWORD, WRONG_LOGIN_OR_PASSWORD_NAME, WRONG_LOGIN_OR_PASSWORD_MASSAGE) &
               isLoginAndPasswordCorrect(req);
    }

    private boolean isLoginAndPasswordCorrect (HttpServletRequest req) throws ServiceException {
        User user = builder.build(req);
        if (!userService.checkPassword(user)) {
            getErrorMap().put(WRONG_LOGIN_OR_PASSWORD_NAME, WRONG_LOGIN_OR_PASSWORD_MASSAGE);
            return false;
        }
        return true;
    }
}
