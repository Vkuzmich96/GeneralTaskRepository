package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.ActionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAction extends Command {
    private ActionService service;
    private static final String ID = "id";

    public GetAction(ActionService service) {
        this.service = service;
    }

    /**
     * Get's Action object fron service, and put it in request attribute
     */
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String key = req.getParameter(ID);
        req.setAttribute(KeyWordsList.ACTION, service.get(key));
        return PagePathList.ACTION;
    }
}
