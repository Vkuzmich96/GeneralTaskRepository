package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
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

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String graphNumber = req.getParameter(KeyWordsList.NUMBER);
        GraphEdge lastEdge = mapService.getLastEdge(graphNumber);
        sessionHandler.setGraphId(req, Integer.parseInt(graphNumber));
        int parentId = lastEdge.getParent().getId();
        if (parentId != 0){
            sessionHandler.incrementStep(req);
        }
        sessionHandler.setActualActionId(req, parentId);
        super.setRedirected(true);
        return PagePathList.LAWER_MENU;
    }
}
