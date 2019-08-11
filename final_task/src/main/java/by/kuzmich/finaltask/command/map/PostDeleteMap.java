package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.LawMapNameService;
import by.kuzmich.finaltask.service.MapService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostDeleteMap extends Command {
    private LawMapNameService nameService;

    public PostDeleteMap(LawMapNameService nameService) {
        this.nameService = nameService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String number = req.getParameter(KeyWordsList.NUMBER);
        nameService.delete(Integer.parseInt(number));
        super.setRedirected(true);
        return PagePathList.NAME_LIST_REDIRECTED;
    }
}
