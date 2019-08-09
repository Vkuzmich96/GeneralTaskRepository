package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;

import javax.servlet.http.HttpServletRequest;

public class UpdateUserValidator extends RegistrationFormValidator {

    @Override
    public boolean isValid(HttpServletRequest req) {
        switch (req.getParameter(KeyWordsList.PROFILE_ACTION_KIND)){
            case KeyWordsList.NAME:
                String name = req.getParameter(KeyWordsList.NAME);
                return isParameterValid(name, STRING_WITH_NUMBERS, WRONG_NAME_NAME, WRONG_NAME_MASSAGE);
            case KeyWordsList.PASSWORD:
                String password = req.getParameter(KeyWordsList.PASSWORD);
                return isParameterValid(password, PASSWORD, WRONG_PASSWORD_NAME, WRONG_PASSWORD_MASSAGE);
            case KeyWordsList.ADDRESS:
                String address = req.getParameter(KeyWordsList.ADDRESS);
                return isParameterValid(address, STRING_WITH_NUMBERS, WRONG_ADDRESS_NAME, WRONG_ADDRESS_MASSAGE);
            case KeyWordsList.PHONE:
                String number = req.getParameter(KeyWordsList.PHONE);
                return isParameterValid(number, NUMBERS, WRONG_NUMBER_NAME, WRONG_NUMBER_MASSAGE);
            default:
                return false;
        }
    }
}
