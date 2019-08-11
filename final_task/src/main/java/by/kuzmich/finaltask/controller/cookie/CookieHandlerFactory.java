package by.kuzmich.finaltask.controller.cookie;

import by.kuzmich.finaltask.bean.User;

public class CookieHandlerFactory {
    private static  CookieHandlerFactory factory = new CookieHandlerFactory();
    private CookieHandlerFactory(){}
    public static CookieHandlerFactory getInstance(){
        return factory;
    }

    public CookieHandler get() {
        return new CookieHandlerLocale();
    }
}
