package by.kuzmich.finaltask.command;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.exception.ControllerException;
import by.kuzmich.finaltask.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public abstract class Command {
    public abstract String execute (HttpServletRequest req, HttpServletResponse resp) throws ServiceException, ControllerException;
    private boolean isRedirected;

    public boolean isRedirected() {
        return isRedirected;
    }

    public void setRedirected(boolean redirected) {
        isRedirected = redirected;
    }

    protected String translateStateInParameters (Map<String, String> state) throws ControllerException {
        Set<Map.Entry<String, String>> set = state.entrySet();
        if (!set.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("?");
            for (Map.Entry<String, String> entry : set) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append('=');
                try {
                    stringBuilder.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    throw new ControllerException(e);
                }
                stringBuilder.append('&');
            }
            return stringBuilder.toString();
        }
        return KeyWordsList.EMPTY_STRING;
    }
}
