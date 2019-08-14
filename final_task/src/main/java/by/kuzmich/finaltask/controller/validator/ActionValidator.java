package by.kuzmich.finaltask.controller.validator;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.exception.ControllerException;

import javax.servlet.http.HttpServletRequest;

public abstract class ActionValidator extends HttpRequestValidator {

    private static final String WRONG_INSTRUCTION_NAME = "wrongInstruction";
    private static final String WRONG_INSTRUCTION_MESSAGE = "wrong.instruction";
    private static final String WRONG_MATERIAL_NAME = "wrongMaterialName";
    private static final String WRONG_DESCRIPTION_NAME = "wrongDescriptionName";
    private static final String WRONG_DESCRIPTION_MESSAGE = "wrong.description";

    @Override
    public boolean isValid(HttpServletRequest req){
        String name = req.getParameter(KeyWordsList.NAME);
        putValidateParameterMap(KeyWordsList.NAME, name);
        String instructions = req.getParameter(KeyWordsList.INSTRUCTIONS);
        putValidateParameterMap(KeyWordsList.INSTRUCTIONS, instructions);
        String materialName = req.getParameter(KeyWordsList.MATERIAL_NAME);
        putValidateParameterMap(KeyWordsList.MATERIAL_NAME, materialName);
        String description = req.getParameter(KeyWordsList.DESCRIPTION);
        putValidateParameterMap(KeyWordsList.DESCRIPTION, description);
        return isParameterValid(name, NAME, WRONG_NAME_NAME, WRONG_NAME_MASSAGE) &&
               isParameterValid(instructions, TEXT, WRONG_INSTRUCTION_NAME, WRONG_INSTRUCTION_MESSAGE)&&
               isParameterValid(materialName, NAME, WRONG_MATERIAL_NAME, WRONG_NAME_MASSAGE) &&
               isParameterValid(description, TEXT, WRONG_DESCRIPTION_NAME, WRONG_DESCRIPTION_MESSAGE);
    }
}
