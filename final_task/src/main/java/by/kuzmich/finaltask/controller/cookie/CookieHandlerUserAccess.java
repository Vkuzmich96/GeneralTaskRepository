package by.kuzmich.finaltask.controller.cookie;

import by.kuzmich.finaltask.bean.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHandlerUserAccess implements CookieHandler<User> {
    private String COOKIE_NAME = "lawmapAccess";

    public void add(HttpServletResponse resp, User user){
        Cookie cookie = new Cookie(COOKIE_NAME, user.getEmail());
        cookie.setPath("*.html");
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
        return "";
    }
}
