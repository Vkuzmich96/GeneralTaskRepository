package by.kuzmich.finaltask.command.builder.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.command.builder.Builder;
import by.kuzmich.finaltask.command.builder.DefaultValues;

import javax.servlet.http.HttpServletRequest;

public class MaterialBuilder implements Builder<Material> {
    @Override
    public Material build(HttpServletRequest req) {
        String url = (String) req.getAttribute(KeyWordsList.URL);
        String description = req.getParameter(KeyWordsList.DESCRIPTION);
        String name = req.getParameter(KeyWordsList.MATERIAL_NAME);
        return new Material(DefaultValues.DEFAULT_ID, url, description, name);
    }
}
