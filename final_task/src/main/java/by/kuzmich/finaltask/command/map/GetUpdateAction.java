package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.ActionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUpdateAction extends Command {
    private ActionService actionService;

    public GetUpdateAction(ActionService actionService) {
        this.actionService = actionService;
    }

    /**
     * Gets Action object from service by number, and puts it in a request attribute
     */
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String number = req.getParameter(KeyWordsList.NUMBER);
        Action action = actionService.get(number);
        req.setAttribute(KeyWordsList.ACTION, action);
        return PagePathList.UPDATE_ACTION;
    }
}
