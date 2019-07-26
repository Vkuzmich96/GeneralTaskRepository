package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;


public class PostMaterial extends Command {

    private String DIRECTORY = "C:\\Users\\user\\IdeaProjects\\GeneralTaskRepository\\final_task\\src\\main\\webapp\\doks";
    private String PARAM_NAME = "file";

    @Override
    public PagePathList execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        try {
            Part filePart = req.getPart(PARAM_NAME);
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
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
        super.setRedirected(true);
        return PagePathList.LAWER_MENU;
    }
}
