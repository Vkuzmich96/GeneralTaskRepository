package by.kuzmich.finaltask.tag;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.Material;

import java.io.IOException;

public class ActionPrinter extends Tag {
    private String prefix ="/doks/";

    private Action action;

    public void setAction(Action action) {
        this.action = action;
    }

    public void renderRootDiv() throws IOException {
        pageContext.getOut().print("<div>");
        pageContext.getOut().print(
                String.format("<h4> %s </h4>", action.getName())
        );
        pageContext.getOut().print(
                String.format("<p> %s </p>", action.getInstructions())
        );
        for (Material material : action.getMaterials()) {
            pageContext.getOut().print(
                    String.format("<p> %s </p>", material.getDiscription())
            );
            pageContext.getOut().print(
                    String.format("%s <a href = %s%s> download </a>", material.getName(), prefix, material.getUrl())
            );
        }
        pageContext.getOut().print("</div>");

    }

}
