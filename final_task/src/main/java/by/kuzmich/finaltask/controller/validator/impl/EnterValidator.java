package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.controller.validator.PatternRegExList;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.kuzmich.finaltask.controller.validator.WarningMessageList.*;
import static by.kuzmich.finaltask.controller.validator.WarningMessageList.WRONG_ADDRESS_MASSAGE;

public class EnterValidator extends UserFormValidator {

    @Override
    public boolean isValid(HttpServletRequest req) {
        switch (req.getParameter(KeyWordsList.PROFILE_ACTION_KIND)){
            case KeyWordsList.NAME:
                return isNameValid(req);
            case KeyWordsList.PASSWORD:
                return isPasswordValid(req);
            case KeyWordsList.ADDRESS:
                return isAddressValid(req);
            case KeyWordsList.PHONE:
                return isNumberValid(req);
            default:
                return false;
        }
    }


    public boolean isPasswordValid (HttpServletRequest req){
        Pattern pattern = Pattern.compile(PatternRegExList.PASSWORD);
        Matcher matcher = pattern.matcher(req.getParameter(KeyWordsList.VALUE));
        if (matcher.find()){
            return true;
        } else {
            req.setAttribute(WRONG_PASSWORD_PARAMETER_NAME, WRONG_PASSWORD_MASSAGE);
            return false;
        }
    }

    public boolean isNameValid (HttpServletRequest req){
        Pattern pattern = Pattern.compile(PatternRegExList.STRING_WITH_NUMBERS);
        Matcher matcher = pattern.matcher(req.getParameter(KeyWordsList.VALUE));
        if (matcher.find()){
            return true;
        } else {
            req.setAttribute(WRONG_NAME_PARAMETER_NAME, WRONG_NAME_MASSAGE);
            return false;
        }
    }

    public boolean isAddressValid (HttpServletRequest req){
        Pattern pattern = Pattern.compile(PatternRegExList.STRING_WITH_NUMBERS);
        Matcher matcher = pattern.matcher(req.getParameter(KeyWordsList.VALUE));
        if (matcher.find()){
            return true;
        } else {
            req.setAttribute(WRONG_ADDRESS_PARAMETER_NAME, WRONG_ADDRESS_MASSAGE);
            return false;
        }
    }

    public boolean isNumberValid (HttpServletRequest req){
        Pattern pattern = Pattern.compile(PatternRegExList.NUMBERS);
        Matcher matcher = pattern.matcher(req.getParameter(KeyWordsList.VALUE));
        if (matcher.find()){
            return true;
        } else {
            req.setAttribute(WRONG_NUMBER_PARAMETER_NAME, WRONG_NUMBER_MASSAGE);
            return false;
        }
    }

}
