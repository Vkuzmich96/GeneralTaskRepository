package by.epam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by Shturik on 08.10.2018.
 */
public final class Utils {

    private Utils(){};

    public static void installInfo(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

    }
}
