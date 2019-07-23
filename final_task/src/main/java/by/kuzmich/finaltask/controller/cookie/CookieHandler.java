package by.kuzmich.finaltask.controller.cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CookieHandler <T> {
    void add(HttpServletResponse resp, T object);
    String getValue (HttpServletRequest req);
    void delete(HttpServletRequest req, HttpServletResponse resp);
}
