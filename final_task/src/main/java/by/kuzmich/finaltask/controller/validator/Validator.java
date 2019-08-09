package by.kuzmich.finaltask.controller.validator;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Validator {
    protected final static Pattern
    EMAIL = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$"),
    PASSWORD = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$"),
    STRING_WITH_NUMBERS = Pattern.compile("^[а-яА-ЯёЁa-zA-Z0-9]+$"),
    NUMBERS = Pattern.compile("^[-0-9]{12,}$");

    protected final static String
    WRONG_LOGIN_OR_PASSWORD_MASSAGE = "Wrong login or password",
    WRONG_LOGIN_OR_PASSWORD_NAME = "wrongLoginOrPassword",

    WRONG_EMAIL_MASSAGE = "invalid email",
    WRONG_EMAIL_NAME = "wrongEmail",

    WRONG_PASSWORD_MASSAGE = "invalid password",
    WRONG_PASSWORD_NAME = "wrongPassword",

    WRONG_NAME_MASSAGE = "invalid name",
    WRONG_NAME_NAME = "wrongName",

    WRONG_ADDRESS_MASSAGE = "invalid address",
    WRONG_ADDRESS_NAME = "wrongAddress",

    WRONG_NUMBER_MASSAGE = "invalid number",
    WRONG_NUMBER_NAME = "wrongNumber";

    private Map<String, String> errorMap = new HashMap<>();

    private Map<String, String> validatedParametersMap = new HashMap<>();

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    protected void putValidateParameterMap(String name, String value){
        validatedParametersMap.put(name, value);
    }

    public Map<String, String> getValidatedParametersMap() {
        return validatedParametersMap;
    }

    public abstract boolean isValid (HttpServletRequest req);

    protected boolean isParameterValid (String parameter, Pattern pattern, String errorMapKey, String errorMessage) {
        Matcher matcher = pattern.matcher(parameter);
        if (matcher.find()) {
            return true;
        } else {
            errorMap.put(errorMapKey, errorMessage);
            return false;
        }
    }
}
