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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetLawyerMenuContinue extends Command {
    private MapService mapService;

    public GetLawyerMenuContinue(MapService mapService) {
        this.mapService = mapService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        Map<String, String> state = new HashMap<>();
        String graphNumber = req.getParameter(KeyWordsList.NUMBER);
        state.put(KeyWordsList.GRAPH_ID, graphNumber);
        List<GraphEdge> edges = mapService.getAll(graphNumber);
        Action actionParent = getLastEdge(edges).getParent();
        String actionId = String.valueOf(getLastEdge(edges).getChild().getId());
        String actionActualId = actionParent != null ? String.valueOf(actionParent.getId()) : KeyWordsList.EMPTY_STRING;
        state.put(KeyWordsList.STEP, KeyWordsList.SECOND_STEP_STRING);
        state.put(KeyWordsList.ACTUAL_ACTION_ID, actionActualId);
        if (actionParent!=null) {
            state.put(KeyWordsList.ACTION_ID, actionId);
        }
        super.setRedirected(true);
        return PagePathList.LAWER_MENU + translateStateInParameters(state);
    }

    private GraphEdge getLastEdge (List<GraphEdge> edges) {
        return edges.get(edges.size() -1);
    }
}
