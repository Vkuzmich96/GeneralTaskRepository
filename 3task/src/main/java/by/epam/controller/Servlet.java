package by.epam.controller;

import by.epam.bean.Candy;
import by.epam.service.Service;
import by.epam.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/parse")
public class Servlet extends HttpServlet {
    private Service service = ServiceFactory.getService();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Utils.installInfo(req, resp);

        String text = req.getParameter("userText");
        String chose = req.getParameter("chose");

        req.setAttribute("text", "doGet" + text + chose);

        req.getRequestDispatcher("/pages/page.jsp").forward(req, resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Utils.installInfo(req, resp);
        List<Candy> candiesList;
        String url = req.getParameter("url");
        String chose = req.getParameter("chose");
        switch (chose){
            case "DOM":
                candiesList = service.parseByDom(url);
                break;
            case "SAX":
                candiesList = service.parseBySax(url);
                break;
            case "StaX":
                candiesList = service.parseByStaX(url);
                break;
            default:
                candiesList = service.parseByDom(url);
        }

        req.setAttribute("list", candiesList);


        req.getRequestDispatcher("/pages/page.jsp").forward(req, resp);
    }
}
