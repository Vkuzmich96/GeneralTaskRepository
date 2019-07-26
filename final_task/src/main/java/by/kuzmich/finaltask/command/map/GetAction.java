package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.service.ActionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class GetAction extends Command {
    private ActionService service;

    public GetAction(ActionService service) {
        this.service = service;
    }

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String key = req.getParameter("id");
        req.setAttribute("action",service.get(key));
        return PagePathList.ACTION;
    }
}
