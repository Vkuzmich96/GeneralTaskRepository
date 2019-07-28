package by.kuzmich.finaltask.command.builder.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.command.builder.Builder;

import javax.servlet.http.HttpServletRequest;

public class ActionParentBuilder implements Builder <Action> {
    @Override
    public Action build(HttpServletRequest req) {
        Action parent = null;
        int step = (int) req.getSession().getAttribute(KeyWordsList.STEP);
        if (step!=KeyWordsList.FIRST_STEP){
            parent = new Action();
            int parentId = (int) req.getSession().getAttribute(KeyWordsList.ACTUAL_ACTION_ID);
            parent.setId(parentId);
        }
        return parent;
    }
}
