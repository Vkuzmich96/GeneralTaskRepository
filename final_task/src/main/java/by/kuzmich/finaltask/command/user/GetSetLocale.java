package by.kuzmich.finaltask.command.user;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetSetLocale extends Command {
    private CookieHandler cookieHandler;

    public GetSetLocale(CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String locale = req.getParameter(KeyWordsList.LOCALE);
        String url = req.getParameter("url");
        cookieHandler.add(resp, locale);
        super.setRedirected(true);
        return url;
    }
}
