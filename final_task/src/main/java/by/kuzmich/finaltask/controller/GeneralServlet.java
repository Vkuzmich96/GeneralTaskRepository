package by.kuzmich.finaltask.controller;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.*;
import by.kuzmich.finaltask.exception.ControllerException;
import by.kuzmich.finaltask.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "*.html")
@MultipartConfig
public class GeneralServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(GeneralServlet.class);

    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        CommandKind kind = (CommandKind) req.getAttribute(KeyWordsList.COMMAND);
        logger.debug(kind);
        Command command = GetCommandFactory.getInstance().get(kind);
        handle(command, req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        CommandKind kind = (CommandKind) req.getAttribute(KeyWordsList.COMMAND);
        logger.debug(kind);
        Command command = PostCommandFactory.getInstance().get(kind);
        handle(command, req, resp);
    }

    private void handle(Command command, HttpServletRequest req, HttpServletResponse resp) {
        try {
            String path = command.execute(req, resp);
            if (command.isRedirected()) {
                doRedirect(path, req, resp);
            } else {
                doForward(path, req, resp);
            }
        } catch (ServiceException | ControllerException | ServletException | IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private void doForward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    private void doRedirect(String url, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + url);
    }
}
