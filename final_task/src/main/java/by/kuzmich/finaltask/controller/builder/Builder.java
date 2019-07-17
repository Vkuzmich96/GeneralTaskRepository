package by.kuzmich.finaltask.controller.builder;

import javax.servlet.http.HttpServletRequest;

public interface Builder<T> {
    T build(HttpServletRequest req);
}
