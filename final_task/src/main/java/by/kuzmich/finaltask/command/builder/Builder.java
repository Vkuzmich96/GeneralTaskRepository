package by.kuzmich.finaltask.command.builder;

import javax.servlet.http.HttpServletRequest;

public interface Builder<T> {
    T build(HttpServletRequest req);
}
