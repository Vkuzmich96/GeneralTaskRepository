package by.kuzmich.finaltask.controller.cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CookieHandler{
    void add(HttpServletResponse resp, String value);
    String getValue (HttpServletRequest req);
    void delete(HttpServletRequest req, HttpServletResponse resp);
}
