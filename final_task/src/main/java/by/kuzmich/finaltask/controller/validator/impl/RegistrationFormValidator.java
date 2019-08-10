package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.controller.validator.RequestValidator;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class RegistrationFormValidator extends RequestValidator {
    private UserService userService;
    private static final String THIS_EMAIL_ALREADY_EXISTS = "Error, this email already exists";


    public RegistrationFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(HttpServletRequest req) throws ServiceException {
        String email = req.getParameter(KeyWordsList.EMAIL);
        putValidateParameterMap(KeyWordsList.EMAIL, email);
        String password = req.getParameter(KeyWordsList.PASSWORD);
        putValidateParameterMap(KeyWordsList.PASSWORD, password);
        String name = req.getParameter(KeyWordsList.NAME);
        putValidateParameterMap(KeyWordsList.NAME, name);
        String address = req.getParameter(KeyWordsList.ADDRESS);
        putValidateParameterMap(KeyWordsList.ADDRESS, address);
        String number = req.getParameter(KeyWordsList.NUMBER);
        putValidateParameterMap(KeyWordsList.NUMBER, number);
        return  isParameterValid(email, EMAIL, WRONG_EMAIL_NAME, WRONG_EMAIL_MASSAGE) &
                isEmailFree(email) &
                isParameterValid(password, PASSWORD, WRONG_PASSWORD_NAME, WRONG_PASSWORD_MASSAGE) &
                isParameterValid(name, NAME, WRONG_NAME_NAME, WRONG_NAME_MASSAGE) &
                isParameterValid(address, ADDRESS, WRONG_ADDRESS_NAME, WRONG_ADDRESS_MASSAGE) &
                isParameterValid(number, NUMBERS, WRONG_NUMBER_NAME, WRONG_NUMBER_MASSAGE);
    }

    private boolean isEmailFree(String email) throws ServiceException {
        if (userService.get(email).getId() != 0) {
            getErrorMap().put(WRONG_EMAIL_NAME, THIS_EMAIL_ALREADY_EXISTS);
            return false;
        }
        return true;
    }
}
