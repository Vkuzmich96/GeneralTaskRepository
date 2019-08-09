package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.controller.validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class RegistrationFormValidator extends Validator {

    @Override
    public boolean isValid(HttpServletRequest req) {
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
                isParameterValid(password, PASSWORD, WRONG_PASSWORD_NAME, WRONG_PASSWORD_MASSAGE) &
                isParameterValid(name, STRING_WITH_NUMBERS, WRONG_NAME_NAME, WRONG_NAME_MASSAGE) &
                isParameterValid(address, STRING_WITH_NUMBERS, WRONG_ADDRESS_NAME, WRONG_ADDRESS_MASSAGE) &
                isParameterValid(number, NUMBERS, WRONG_NUMBER_NAME, WRONG_NUMBER_MASSAGE);
    }
}
