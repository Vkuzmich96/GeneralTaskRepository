package by.kuzmich.finaltask.command.builder.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.command.builder.DefaultValues;
import by.kuzmich.finaltask.controller.cookie.CookieHandler;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionChildBuilder implements Builder<Action> {
    private UserService userService;
    private CookieHandler cookieHandler;

    public ActionChildBuilder(UserService userService, CookieHandler cookieHandler) {
        this.userService = userService;
        this.cookieHandler = cookieHandler;
    }

    @Override
    public Action build(HttpServletRequest req) {
        String login = cookieHandler.getValue(req);
        User user = null;
        try {
            user = userService.get(login);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        String name = req.getParameter(KeyWordsList.NAME);
        String instructions = req.getParameter(KeyWordsList.INSTRUCTIONS);
        Material material = buildMaterial(req);
        List<Material> materialList = new ArrayList<>();
        materialList.add(material);
        return new Action(DefaultValues.DEFAULT_ID, name, instructions,materialList, user);
    }

    private Material buildMaterial (HttpServletRequest req) {
        Part filePart = null;
        try {
            filePart = req.getPart(KeyWordsList.FILE_PARAMETER_NAME);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        String url = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String description = req.getParameter(KeyWordsList.DESCRIPTION);
        String name = req.getParameter(KeyWordsList.NAME);
        return new Material(DefaultValues.DEFAULT_ID, url, description, name);
    }
}
