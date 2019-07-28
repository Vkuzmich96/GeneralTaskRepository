package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.GraphEdge;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.service.ActionService;
import by.kuzmich.finaltask.service.MapService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class PostAction extends Command {
    private ActionService actionService;
    private Builder<Action> childActionBuilder;
    private Builder<Action> parentActionBuilder;
    private SessionHandler sessionHandler;
    private MapService mapService;


    public PostAction(ActionService actionService, Builder<Action> childActionBuilder, Builder<Action> parentActionBuilder, SessionHandler sessionHandler, MapService mapService) {
        this.actionService = actionService;
        this.childActionBuilder = childActionBuilder;
        this.parentActionBuilder = parentActionBuilder;
        this.sessionHandler = sessionHandler;
        this.mapService = mapService;
    }

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Action child = childActionBuilder.build(req);
        int childId = actionService.add(child);
        child.setId(childId);
        if ("on".equals(req.getParameter(KeyWordsList.IS_NEXT))){
            sessionHandler.incrementStep(req);
            sessionHandler.changeActualActionId(req);
        }
        sessionHandler.setActionId(req, childId);
        Action parent = parentActionBuilder.build(req);
        int graphId = sessionHandler.getGraphId(req);
        mapService.addEdge(new GraphEdge(graphId, parent, child));
        super.setRedirected(true);
        return PagePathList.LAWER_MENU;
    }

    private void addmaterial(HttpServletRequest req, HttpServletResponse resp){

    }
}
