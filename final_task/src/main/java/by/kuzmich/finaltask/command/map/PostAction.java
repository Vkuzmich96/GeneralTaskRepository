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
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        Action child = childActionBuilder.build(req);
        int childId = actionService.add(child);
        child.setId(childId);
        nextStepHandler(req);
        sessionHandler.setActionId(req, childId);
        Action parent = parentActionBuilder.build(req);
        int graphId = sessionHandler.getGraphId(req);
        fileHandler(req);
        mapService.addEdge(new GraphEdge(graphId, parent, child));
        super.setRedirected(true);
        return PagePathList.LAWER_MENU;
    }

    private void nextStepHandler(HttpServletRequest req){
        if (NEXT_STEP_FLAG_ON.equals(req.getParameter(KeyWordsList.IS_NEXT))){
            sessionHandler.incrementStep(req);
            sessionHandler.changeActualActionId(req);
        }
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
