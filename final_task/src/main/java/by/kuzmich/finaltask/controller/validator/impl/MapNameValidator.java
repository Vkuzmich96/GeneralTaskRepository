package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.controller.validator.RequestValidator;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.LawMapNameService;
import javax.servlet.http.HttpServletRequest;

public class MapNameValidator extends RequestValidator {
    private LawMapNameService nameService;
    private final static String THIS_NAME_ALREADY_EXISTS = "this.name.already.exists";

    public MapNameValidator(LawMapNameService nameService) {
        this.nameService = nameService;
    }

    @Override
    public boolean isValid(HttpServletRequest req) throws ServiceException {
        String name = req.getParameter(KeyWordsList.NAME);
        putValidateParameterMap(KeyWordsList.NAME, name);
        return isParameterValid(name, NAME, WRONG_NAME_NAME, WRONG_NAME_MASSAGE) && isNameFree(name);
    }

    private boolean isNameFree (String name) throws ServiceException {
        if (nameService.isNameFree(name)) {
            return true;
        }
        getErrorMap().put(WRONG_NAME_NAME, THIS_NAME_ALREADY_EXISTS);
        return false;
    }
}
