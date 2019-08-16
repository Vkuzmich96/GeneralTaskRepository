package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.LawMapNameService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostRealise extends Command {
    private LawMapNameService nameService;

    public PostRealise (LawMapNameService nameService) {
        this.nameService = nameService;
    }

    /**
     * Changes lawMapName object state on reade
     */
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String number = req.getParameter(KeyWordsList.NUMBER);
        nameService.realise(number);
        super.setRedirected(true);
        return PagePathList.NAME_LIST_REDIRECTED;
    }
}
