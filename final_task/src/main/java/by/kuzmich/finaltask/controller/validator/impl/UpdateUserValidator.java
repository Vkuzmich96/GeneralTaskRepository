package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;

import javax.servlet.http.HttpServletRequest;

public class UpdateUserValidator extends RegistrationFormValidator {

    @Override
    public boolean isValid(HttpServletRequest req) {
        String value = req.getParameter(KeyWordsList.VALUE);
        String kind = req.getParameter(KeyWordsList.PROFILE_ACTION_KIND);
        putValidateParameterMap(KeyWordsList.VALUE, value);
        putValidateParameterMap(KeyWordsList.PROFILE_ACTION_KIND, kind);
        switch (req.getParameter(KeyWordsList.PROFILE_ACTION_KIND)){
            case KeyWordsList.NAME:
                return isParameterValid(value, NAME, WRONG_NAME_NAME, WRONG_NAME_MASSAGE);
            case KeyWordsList.PASSWORD:
                return isParameterValid(value, PASSWORD, WRONG_PASSWORD_NAME, WRONG_PASSWORD_MASSAGE);
            case KeyWordsList.ADDRESS:
                return isParameterValid(value, ADDRESS, WRONG_ADDRESS_NAME, WRONG_ADDRESS_MASSAGE);
            case KeyWordsList.PHONE:
                return isParameterValid(value, NUMBERS, WRONG_NUMBER_NAME, WRONG_NUMBER_MASSAGE);
            default:
                return false;
        }
    }
}
