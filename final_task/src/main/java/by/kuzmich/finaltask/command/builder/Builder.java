package by.kuzmich.finaltask.command.builder;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface Builder<T> {
    T build(HttpServletRequest req);
}
