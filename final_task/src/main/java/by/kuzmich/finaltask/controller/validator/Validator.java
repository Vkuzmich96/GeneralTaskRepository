package by.kuzmich.finaltask.controller.validator;

import javax.servlet.http.HttpServletRequest;

public interface Validator {
    boolean isValid (HttpServletRequest req);
}
