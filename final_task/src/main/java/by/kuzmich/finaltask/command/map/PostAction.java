package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.GraphEdge;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.exception.ControllerException;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.ActionService;
import by.kuzmich.finaltask.service.MapService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public class PostAction extends Command {
    private String DIRECTORY;
    private ActionService actionService;
    private Builder<Action> childActionBuilder;
    private Builder<Action> parentActionBuilder;
    private MapService mapService;

    public PostAction(ActionService actionService, Builder<Action> childActionBuilder, Builder<Action> parentActionBuilder, MapService mapService, String directoryPath) {
        this.actionService = actionService;
        this.childActionBuilder = childActionBuilder;
        this.parentActionBuilder = parentActionBuilder;
        this.mapService = mapService;
        this.DIRECTORY = directoryPath;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, ControllerException {
        Map<String, String> state = getState(req);
        Action child = childActionBuilder.build(req);
        int childId = actionService.add(child);
        child.setId(childId);
        nextStepHandler(req, state);
        state.put(KeyWordsList.ACTION_ID, String.valueOf(childId));
        req.setAttribute(KeyWordsList.STATE, state);
        Action parent = parentActionBuilder.build(req);
        int graphId = Integer.parseInt(req.getParameter(KeyWordsList.GRAPH_ID));
        req.setAttribute(KeyWordsList.GRAPH_ID, graphId);
        fileHandler(req);
        mapService.addEdge(new GraphEdge(graphId, parent, child));
        super.setRedirected(true);
        return PagePathList.LAWER_MENU + translateStateInParameters(state);
    }

    private void nextStepHandler(HttpServletRequest req, Map<String, String> state){
        if (KeyWordsList.NEXT_STEP_FLAG_ON.equals(req.getParameter(KeyWordsList.IS_NEXT))){
            incrementStep(state);
            changeActualActionId(state);
        }
    }

    private Map<String, String> getState (HttpServletRequest req){
        Map<String, String> state = new HashMap<>();
        String graphId = req.getParameter(KeyWordsList.GRAPH_ID);
        state.put(KeyWordsList.GRAPH_ID, graphId);
        String step = req.getParameter(KeyWordsList.STEP);
        state.put(KeyWordsList.STEP, KeyWordsList.EMPTY_STRING.equals(step) ? KeyWordsList.FIRST_STEP_STRING : step);
        String actionId = req.getParameter(KeyWordsList.ACTION_ID);
        if (!KeyWordsList.EMPTY_STRING.equals(actionId)) {
            state.put(KeyWordsList.ACTION_ID, actionId);
        }
        String actualParentId = req.getParameter(KeyWordsList.ACTUAL_ACTION_ID);
        state.put(KeyWordsList.ACTUAL_ACTION_ID, actualParentId);
        return state;
    }

    private void incrementStep(Map<String, String> state){
        Integer step = Integer.parseInt(state.get(KeyWordsList.STEP));
        step = ++step;
        state.put(KeyWordsList.STEP, step.toString());
    }

    private void changeActualActionId(Map<String, String> state) {
        String id = state.get(KeyWordsList.ACTION_ID);
        state.put(KeyWordsList.ACTUAL_ACTION_ID, id);
    }

    private void fileHandler(HttpServletRequest req){
        try {
            Part filePart = req.getPart(KeyWordsList.FILE_PARAMETER_NAME);
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            req.setAttribute(KeyWordsList.URL, fileName);
            File file = new File(DIRECTORY, fileName);
            file.createNewFile();
            InputStream inputStream = filePart.getInputStream();
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(buffer);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
