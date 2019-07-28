package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.bean.Graph;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.service.MapService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class GetMap extends Command {

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String number = req.getParameter(KeyWordsList.NUMBER);
        req.setAttribute(KeyWordsList.NUMBER, number);
        return PagePathList.MAP;
    }
}
