package by.kuzmich.finaltask.command;

import by.kuzmich.finaltask.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public abstract class Command {
    public abstract String execute (HttpServletRequest req, HttpServletResponse resp) throws ServiceException;
    private boolean isRedirected;

    public boolean isRedirected() {
        return isRedirected;
    }

    public void setRedirected(boolean redirected) {
        isRedirected = redirected;
    }
}
