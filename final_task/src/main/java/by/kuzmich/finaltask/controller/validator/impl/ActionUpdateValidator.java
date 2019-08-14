package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.controller.validator.ActionValidator;

import javax.servlet.http.HttpServletRequest;

public class ActionUpdateValidator extends ActionValidator {

    @Override
    public boolean isValid(HttpServletRequest req) {
        String number = req.getParameter(KeyWordsList.NUMBER);
        putValidateParameterMap(KeyWordsList.NUMBER, number);
        return super.isValid(req);
    }
}
