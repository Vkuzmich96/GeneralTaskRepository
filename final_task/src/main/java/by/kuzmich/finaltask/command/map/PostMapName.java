package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.KeyWordsList;
import by.kuzmich.finaltask.service.LawMapNameService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class PostMapName extends Command {
    private LawMapNameService nameService;

    public PostMapName(LawMapNameService nameService) {
        this.nameService = nameService;
    }
    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String lawMapName = req.getParameter("name");
        int id = nameService.add(lawMapName);
        req.getSession().setAttribute(KeyWordsList.GRAPH_ID, id);
        super.setRedirected(true);
        return PagePathList.LAWER_MENU;
    }
}
