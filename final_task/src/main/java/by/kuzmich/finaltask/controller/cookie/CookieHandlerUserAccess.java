package by.kuzmich.finaltask.controller.cookie;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.KeyWordsList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHandlerUserAccess implements CookieHandler<User> {
    private String COOKIE_NAME = "lawmapAccess";
    private int DELETE_KEY = 0;
    private String postfix = "*.html";
    //TODO токен COOKIE_TOKEN
    public void add(HttpServletResponse resp, User user){
        Cookie cookie = new Cookie(COOKIE_NAME, user.getEmail());
        cookie.setPath(postfix);
        resp.addCookie(cookie);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp){
        Cookie cookie = new Cookie(COOKIE_NAME, getValue(req));
        cookie.setPath(postfix);
        cookie.setMaxAge(DELETE_KEY);
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
