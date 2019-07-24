package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class GetLawerMenu extends Command {
    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        super.setRedirected(true);
        return PagePathList.LAWER_MENU;
    }
}
