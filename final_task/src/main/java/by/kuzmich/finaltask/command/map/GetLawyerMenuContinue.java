package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.GraphEdge;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.MapService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetLawyerMenuContinue extends Command {
    private SessionHandler sessionHandler;
    private MapService mapService;

    public GetLawyerMenuContinue(SessionHandler sessionHandler, MapService mapService) {
        this.sessionHandler = sessionHandler;
        this.mapService = mapService;
    }

    //todo нашёл баг, если сразу после логирования переходить к добавлению нового этапа, то экшен добавится в конец,
    //todo а не перейдёт на новый этап. Нам нужен предпоследний предок, чтобы исправить эту проблему.
    //todo Резюме: добавить метод который будет просто тащить из бд список рёбер графа и доставть всё что нам нужно здесь.
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String graphNumber = req.getParameter(KeyWordsList.NUMBER);
        GraphEdge lastEdge = mapService.getLastEdge(graphNumber);
        sessionHandler.setGraphId(req, Integer.parseInt(graphNumber));
        Action parent = lastEdge.getParent();
        int parentId = parent != null ? parent.getId() : 0;
        if (parentId != 0) {
            sessionHandler.incrementStep(req);
            sessionHandler.setActionId(req, parentId);
            sessionHandler.setActualActionId(req, parentId);
        }
        super.setRedirected(true);
        return PagePathList.LAWER_MENU;
    }
}
