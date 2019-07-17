package by.kuzmich.finaltask.controller;

import by.kuzmich.finaltask.action.Command;
import by.kuzmich.finaltask.action.CommandFactory;
import by.kuzmich.finaltask.action.CommandKind;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "*.html")
public class GeneralServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        CommandKind kind = (CommandKind) req.getAttribute("action");
        Command command = CommandFactory.getInstance().get(kind);
        command.execute(req, resp);
    }

}
