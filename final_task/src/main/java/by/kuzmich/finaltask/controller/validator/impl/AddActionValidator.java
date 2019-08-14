package by.kuzmich.finaltask.controller.validator.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.controller.validator.ActionValidator;
import by.kuzmich.finaltask.exception.ExceptionMessageList;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AddActionValidator extends ActionValidator {
    private static Logger logger = Logger.getLogger(AddActionValidator.class);
    private static final String IMPOSSIBLE_TO_READ_FILE = "impossibleToReade";
    private static final String IMPOSSIBLE_TO_READ_FILE_MESSAGE = "impossible.to.reade";

    @Override
    public boolean isValid(HttpServletRequest req){
        saveParameters(req);
        return super.isValid(req) && isFileExists(req);
    }

    private boolean isFileExists (HttpServletRequest req) {
        try {
            return req.getPart(KeyWordsList.FILE_PARAMETER_NAME).getSize() != 0;
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            logger.error(ExceptionMessageList.IMPOSSIBLE_TO_READ_FILE_FROM_FORM, e);
        } finally {
            putValidateParameterMap(IMPOSSIBLE_TO_READ_FILE, IMPOSSIBLE_TO_READ_FILE_MESSAGE);
        }
        return false;
    }

    private void saveParameters (HttpServletRequest req) {
        String graphId = req.getParameter(KeyWordsList.GRAPH_ID);
        if (graphId != null) {
            putValidateParameterMap(KeyWordsList.GRAPH_ID, graphId);
        }
        String step = req.getParameter(KeyWordsList.STEP);
        if(step != null) {
            putValidateParameterMap(KeyWordsList.STEP, step);
        }
        String actionId = req.getParameter(KeyWordsList.ACTION_ID);
        if (actionId != null) {
            putValidateParameterMap(KeyWordsList.ACTION_ID, actionId);
        }
        String actualActionId = req.getParameter(KeyWordsList.ACTUAL_ACTION_ID);
        if (actualActionId != null) {
            putValidateParameterMap(KeyWordsList.ACTUAL_ACTION_ID, actualActionId);
        }
    }
}
