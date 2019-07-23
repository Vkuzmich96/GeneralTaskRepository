package by.kuzmich.finaltask.controller.session;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.controller.cookie.CookieHandlerUserAccess;

public class SessionHandlerFactory {
    private static SessionHandlerFactory factory = new SessionHandlerFactory();
    private SessionHandlerFactory(){}
    public static SessionHandlerFactory getInstance(){
        return factory;
    }

    public SessionHandler get() {
        return new SessionHandlerUser();
    }
}
