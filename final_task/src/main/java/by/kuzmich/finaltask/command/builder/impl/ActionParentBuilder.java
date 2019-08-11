package by.kuzmich.finaltask.command.builder.impl;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.command.builder.Builder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ActionParentBuilder implements Builder <Action> {
    @Override
    public Action build(HttpServletRequest req) {
        Map<String, String> state = (Map<String, String>) req.getAttribute(KeyWordsList.STATE);
        Action parent = null;
        String stepI = state.get(KeyWordsList.STEP);
        int step = !stepI.equals("") ? Integer.parseInt(stepI) :  KeyWordsList.FIRST_STEP;
        if (step > KeyWordsList.FIRST_STEP){
            parent = new Action();
            int parentId = Integer.parseInt(state.get(KeyWordsList.ACTUAL_ACTION_ID));
            parent.setId(parentId);
        }
        return parent;
    }
}
