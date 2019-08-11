package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.GraphEdge;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.controller.session.SessionHandler;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.ActionService;
import by.kuzmich.finaltask.service.MapService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class PostAction extends Command {
    private String DIRECTORY = "C:\\Users\\user\\IdeaProjects\\GeneralTaskRepository\\final_task\\src\\main\\webapp\\doks";
    private String NEXT_STEP_FLAG_ON = "on";
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
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        Action child = childActionBuilder.build(req);
        int childId = actionService.add(child);
        child.setId(childId);
        resetActionId(req);
        nextStepHandler(req);
        req.setAttribute(KeyWordsList.ACTION_ID, childId);
        Action parent = parentActionBuilder.build(req);
        int graphId = Integer.parseInt(req.getParameter(KeyWordsList.GRAPH_ID));
        req.setAttribute(KeyWordsList.GRAPH_ID, graphId);
        fileHandler(req);
        mapService.addEdge(new GraphEdge(graphId, parent, child));
        return PagePathList.LAWER_MENU;
    }

    private void nextStepHandler(HttpServletRequest req){
        if (NEXT_STEP_FLAG_ON.equals(req.getParameter(KeyWordsList.IS_NEXT))){
            incrementStep(req);
            changeActualActionId(req);
        } else {
            Integer step = Integer.parseInt(req.getParameter(KeyWordsList.STEP));
            if(step > KeyWordsList.FIRST_STEP) {
                Integer actualParentId = Integer.parseInt(req.getParameter(KeyWordsList.ACTUAL_ACTION_ID));
                req.setAttribute(KeyWordsList.ACTUAL_ACTION_ID, actualParentId);
                req.setAttribute(KeyWordsList.STEP, step);
            }
        }
    }

    private void resetActionId(HttpServletRequest req){
        String actionId = req.getParameter(KeyWordsList.ACTION_ID);
        if (!"".equals(actionId)) {
            Integer id = Integer.parseInt(actionId);
            req.setAttribute(KeyWordsList.ACTION_ID, id);
        }
    }

    public void incrementStep(HttpServletRequest req){
        Integer step = Integer.parseInt(req.getParameter(KeyWordsList.STEP));
        step = ++step;
        req.setAttribute(KeyWordsList.STEP, step);
    }

    public void changeActualActionId(HttpServletRequest req) {
        Integer id = (Integer) req.getAttribute(KeyWordsList.ACTION_ID);
        req.setAttribute(KeyWordsList.ACTUAL_ACTION_ID, id);
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
