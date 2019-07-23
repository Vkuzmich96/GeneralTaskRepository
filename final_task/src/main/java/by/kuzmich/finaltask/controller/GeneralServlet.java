package by.kuzmich.finaltask.controller;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.CommandFactory;
import by.kuzmich.finaltask.command.CommandKind;
import by.kuzmich.finaltask.command.PagePathList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "*.html")
public class GeneralServlet extends HttpServlet {
    private String COMMAND_ENUM_ATTRIBUTE = "command";

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandKind kind = (CommandKind) req.getAttribute(COMMAND_ENUM_ATTRIBUTE);
        Command command = CommandFactory.getInstance().get(kind);
        String url = null;
        try {
            PagePathList pathEnum = command.execute(req, resp);
            url = pathEnum.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(command.isRedirected()){
            doRedirect(url,req,resp);
        }else{
            doForward(url,req,resp);
        }
    }

    private void doForward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    private void doRedirect(String url, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + url);
    }
}
