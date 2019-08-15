package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.controller.validator.HttpRequestValidator;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class UpdateUserValidator extends HttpRequestValidator {
    private Builder<User> builder;
    private UserService userService;
    private static final String WRONG_OLD_PASSWORD_MESSAGE = "wrong.old.password";
    private static final String TYPO_IN_PASSWORDS = "typo.in.passwords";


    public UpdateUserValidator(Builder<User> builder, UserService userService) {
        this.builder = builder;
        this.userService = userService;
    }

    @Override
    public boolean isValid(HttpServletRequest req) throws ServiceException {
        String value = req.getParameter(KeyWordsList.VALUE);
        String kind = req.getParameter(KeyWordsList.PROFILE_ACTION_KIND);
        putValidateParameterMap(KeyWordsList.VALUE, value);
        putValidateParameterMap(KeyWordsList.PROFILE_ACTION_KIND, kind);
        switch (req.getParameter(KeyWordsList.PROFILE_ACTION_KIND)){
            case KeyWordsList.NAME:
                return isParameterValid(value, NAME, WRONG_NAME_NAME, WRONG_NAME_MASSAGE);
            case KeyWordsList.PASSWORD:
                return isParameterValid(value, PASSWORD, WRONG_PASSWORD_NAME, WRONG_PASSWORD_MASSAGE) &&
                       isOldPasswordTrue(req) &&
                       isNewAndCheckEquals(req);
            case KeyWordsList.ADDRESS:
                return isParameterValid(value, ADDRESS, WRONG_ADDRESS_NAME, WRONG_ADDRESS_MASSAGE);
            case KeyWordsList.PHONE:
                return isParameterValid(value, NUMBERS, WRONG_NUMBER_NAME, WRONG_NUMBER_MASSAGE);
            default:
                return false;
        }
    }

    private boolean isOldPasswordTrue (HttpServletRequest req) throws ServiceException {
        User user = builder.build(req);
        if (!userService.checkPassword(user)) {
            getErrorMap().put(WRONG_PASSWORD_NAME, WRONG_OLD_PASSWORD_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isNewAndCheckEquals(HttpServletRequest req) {
        String newPassword = req.getParameter(KeyWordsList.VALUE);
        String checkPassword = req.getParameter(KeyWordsList.CHECK_VALUE);
        if(newPassword.equals(checkPassword)){
            return true;
        } else {
            getErrorMap().put(WRONG_PASSWORD_NAME, TYPO_IN_PASSWORDS);
            return false;
        }
    }
}
