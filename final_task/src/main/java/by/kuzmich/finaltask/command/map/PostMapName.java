package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.LawMapName;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.LawMapNameService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostMapName extends Command {
    private LawMapNameService nameService;
    private SessionHandler sessionHandler;

    public PostMapName(LawMapNameService nameService, SessionHandler sessionHandler) {
        this.nameService = nameService;
        this.sessionHandler = sessionHandler;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String name = req.getParameter(KeyWordsList.NAME);
        LawMapName lawMapName = new LawMapName(0, name, false);
        int id = nameService.add(lawMapName);
        super.setRedirected(true);
        return PagePathList.LAWER_MENU + "?" + KeyWordsList.GRAPH_ID + "=" + id;
    }
}
