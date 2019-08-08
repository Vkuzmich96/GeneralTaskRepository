package by.kuzmich.finaltask.controller.validator.impl;

import javax.servlet.http.HttpServletRequest;

public class UserUpdateValidator extends UserFormValidator{
    @Override
    public boolean isValid(HttpServletRequest req) {
        return super.isEmailValid(req) & super.isPasswordValid(req);
    }
}
