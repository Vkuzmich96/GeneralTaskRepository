package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.controller.validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class EnterUserValidator extends Validator {
    @Override
    public boolean isValid (HttpServletRequest req) {
        String email = req.getParameter(KeyWordsList.EMAIL);
        putValidateParameterMap(KeyWordsList.EMAIL, email);
        String password = req.getParameter(KeyWordsList.PASSWORD);
        putValidateParameterMap(KeyWordsList.PASSWORD, password);
        return isParameterValid(email, EMAIL, WRONG_LOGIN_OR_PASSWORD_NAME, WRONG_LOGIN_OR_PASSWORD_MASSAGE) &
               isParameterValid(password, PASSWORD, WRONG_LOGIN_OR_PASSWORD_NAME, WRONG_LOGIN_OR_PASSWORD_MASSAGE);
    }
}
