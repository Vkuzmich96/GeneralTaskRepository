package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.bean.Graph;
import by.kuzmich.finaltask.service.MapService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class MapGet extends Command {
    private MapService service;

    public MapGet(MapService service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String number = req.getParameter("number");
        Graph graph = service.get(number);
        req.setAttribute("graph", graph);
        return "/pages/lawmap.jsp";
    }
}
