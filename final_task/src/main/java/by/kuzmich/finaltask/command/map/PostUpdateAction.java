package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.ActionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostUpdateAction extends Command {
    private ActionService actionService;

    public PostUpdateAction(ActionService actionService) {
        this.actionService = actionService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String actionId = req.getParameter(KeyWordsList.ACTION_ID);
        Action action = actionService.get(actionId);
        String name = req.getParameter(KeyWordsList.NAME);
        action.setName(name);
        String instructions = req.getParameter(KeyWordsList.INSTRUCTIONS);
        action.setInstructions(instructions);
        Material material = action.getMaterials().get(0);
        String materialName = req.getParameter(KeyWordsList.MATERIAL_NAME);
        material.setName(materialName);
        String description = req.getParameter(KeyWordsList.DESCRIPTION);
        material.setDiscription(description);
        actionService.update(action);
        super.setRedirected(true);
        return PagePathList.NAME_LIST_REDIRECTED;
    }
}
