package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.service.LawMapNameService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class PostMapName extends Command {
    private LawMapNameService nameService;
    private SessionHandler sessionHandler;

    public PostMapName(LawMapNameService nameService, SessionHandler sessionHandler) {
        this.nameService = nameService;
        this.sessionHandler = sessionHandler;
    }

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String lawMapName = req.getParameter("name");
        int id = nameService.add(lawMapName);
        sessionHandler.setGraphId(req, id);
        super.setRedirected(true);
        return PagePathList.LAWER_MENU;
    }
}
