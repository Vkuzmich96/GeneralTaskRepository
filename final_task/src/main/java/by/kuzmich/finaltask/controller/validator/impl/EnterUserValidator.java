package by.kuzmich.finaltask.controller.validator.impl;

import javax.servlet.http.HttpServletRequest;

public class EnterUserValidator extends RegistrationFormValidator{
    @Override
    public boolean isValid(HttpServletRequest req) {
        return super.isEmailValid(req) & super.isPasswordValid(req);
    }
}
