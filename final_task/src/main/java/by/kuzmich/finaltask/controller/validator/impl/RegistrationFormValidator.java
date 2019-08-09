package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.controller.validator.PatternRegExList;
import by.kuzmich.finaltask.controller.validator.Validator;
import static by.kuzmich.finaltask.controller.validator.WarningMessageList.*;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationFormValidator implements Validator {

    @Override
    public boolean isValid(HttpServletRequest req) {
        return isEmailValid(req) & isPasswordValid(req) & isNameValid(req)  & isAddressValid(req) & isNumberValid(req);
    }

    public boolean isEmailValid (HttpServletRequest req) {
        Pattern pattern = Pattern.compile(PatternRegExList.EMAIL);
        Matcher matcher = pattern.matcher(req.getParameter(KeyWordsList.EMAIL));
        if (matcher.find()) {
            return true;
        } else {
            req.setAttribute(WRONG_EMAIL_PARAMETER_NAME, WRONG_EMAIL_MASSAGE);
            return false;
        }
    }

    public boolean isPasswordValid (HttpServletRequest req){
        Pattern pattern = Pattern.compile(PatternRegExList.PASSWORD);
        Matcher matcher = pattern.matcher(req.getParameter(KeyWordsList.PASSWORD));
        if (matcher.find()){
            return true;
        } else {
            req.setAttribute(WRONG_PASSWORD_PARAMETER_NAME, WRONG_PASSWORD_MASSAGE);
            return false;
        }
    }

    public boolean isNameValid (HttpServletRequest req){
        Pattern pattern = Pattern.compile(PatternRegExList.STRING_WITH_NUMBERS);
        Matcher matcher = pattern.matcher(req.getParameter(KeyWordsList.NAME));
        if (matcher.find()){
            return true;
        } else {
            req.setAttribute(WRONG_NAME_PARAMETER_NAME, WRONG_NAME_MASSAGE);
            return false;
        }
    }

    public boolean isAddressValid (HttpServletRequest req){
        Pattern pattern = Pattern.compile(PatternRegExList.STRING_WITH_NUMBERS);
        Matcher matcher = pattern.matcher(req.getParameter(KeyWordsList.ADDRESS));
        if (matcher.find()){
            return true;
        } else {
            req.setAttribute(WRONG_ADDRESS_PARAMETER_NAME, WRONG_ADDRESS_MASSAGE);
            return false;
        }
    }

    public boolean isNumberValid (HttpServletRequest req){
        Pattern pattern = Pattern.compile(PatternRegExList.NUMBERS);
        Matcher matcher = pattern.matcher(req.getParameter(KeyWordsList.NUMBER));
        if (matcher.find()){
            return true;
        } else {
            req.setAttribute(WRONG_NUMBER_PARAMETER_NAME, WRONG_NUMBER_MASSAGE);
            return false;
        }
    }
}
