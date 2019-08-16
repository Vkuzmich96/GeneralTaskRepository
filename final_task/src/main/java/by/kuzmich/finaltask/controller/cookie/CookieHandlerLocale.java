package by.kuzmich.finaltask.controller.cookie;

import by.kuzmich.finaltask.KeyWordsList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHandlerLocale implements CookieHandler {
    private final static String COOKIE_NAME = "lang";
    private final static int DELETE_LOCALE= 0;
    private final static String POSTFIX = "/";

    public void add(HttpServletResponse resp, String locale){
        Cookie cookie = new Cookie(COOKIE_NAME, locale);
        cookie.setPath(POSTFIX);
        resp.addCookie(cookie);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp){
        Cookie cookie = new Cookie(COOKIE_NAME, getValue(req));
        cookie.setPath(POSTFIX);
        cookie.setMaxAge(DELETE_LOCALE);
        resp.addCookie(cookie);
    }

    public String getValue (HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies){
            String name = cookie.getName();
            if(COOKIE_NAME.equals(name)){
                return cookie.getValue();
            }
        }
        return KeyWordsList.EMPTY_COOKIE_VALUE;
    }
}
