package by.kuzmich.finaltask.controller;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.CommandFactory;
import by.kuzmich.finaltask.command.CommandKind;
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

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandKind kind = (CommandKind) req.getAttribute(KeyWordsList.COMMAND);
        logger.debug(kind);
        Command command = CommandFactory.getInstance().get(kind);
        String path = null;
        try {
            path = command.execute(req, resp);
        } catch (ServiceException | ControllerException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        if(command.isRedirected()){
            doRedirect(path,req,resp);
        }else{
            doForward(path,req,resp);
        }
    }

    private void doForward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    private void doRedirect(String url, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + url);
    }
}
