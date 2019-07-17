package by.kuzmich.finaltask.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public abstract class Command {
    public abstract String execute (HttpServletRequest req, HttpServletResponse resp) throws SQLException;
    private boolean isRedirected;

    public boolean isRedirected() {
        return isRedirected;
    }

    public void setRedirected(boolean redirected) {
        isRedirected = redirected;
    }
}
