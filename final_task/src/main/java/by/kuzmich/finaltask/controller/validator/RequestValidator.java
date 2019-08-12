package by.kuzmich.finaltask.controller.validator;

import by.kuzmich.finaltask.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class RequestValidator {
    protected final static Pattern
    EMAIL = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$"),
    PASSWORD = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$"),
    ADDRESS = Pattern.compile("^[-а-яА-ЯёЁa-zA-Z0-9 ,.]{4,50}$"),
    NAME = Pattern.compile("^[-а-яА-ЯёЁa-zA-Z ]{4,45}$"),
    NUMBERS = Pattern.compile("^[-0-9]{12}$");

    protected final static String
    WRONG_EMAIL_MASSAGE = "wrong.email",
    WRONG_EMAIL_NAME = "wrongEmail",

    WRONG_PASSWORD_MASSAGE = "wrong.password",
    WRONG_PASSWORD_NAME = "wrongPassword",

    WRONG_NAME_MASSAGE = "wrong.name",
    WRONG_NAME_NAME = "wrongName",

    WRONG_ADDRESS_MASSAGE = "wrong.address",
    WRONG_ADDRESS_NAME = "wrongAddress",

    WRONG_NUMBER_MASSAGE = "wrong.number",
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

    public abstract boolean isValid (HttpServletRequest req) throws ServiceException;

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
