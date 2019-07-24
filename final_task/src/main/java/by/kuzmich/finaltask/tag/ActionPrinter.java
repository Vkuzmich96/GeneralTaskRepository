package by.kuzmich.finaltask.tag;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.Material;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class ActionPrinter extends TagSupport {
    private static final long serialVersionUID = 1L;
    private String prefix ="/doks/";

    private Action action;

    public void setAction(Action action) {
        this.action = action;
    }

    public int doStartTag() throws JspException {
        try {
            renderRootDiv();
        } catch(IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }
        return SKIP_BODY;
    }

    private void renderRootDiv() throws IOException {
        pageContext.getOut().print("<div>");
        pageContext.getOut().print(String.format("<h4> %s </h4>", action.getName()));
        pageContext.getOut().print(String.format("<p> %s </p>", action.getInstructions()));
        for (Material material : action.getMaterials()) {
            pageContext.getOut().print(String.format("<p> %s </p>", material.getDiscription()));
            pageContext.getOut().print(
                    String.format("<a href = %s%s>download</a>", prefix, material.getUrl())
            );
        }
        pageContext.getOut().print("</div>");

    }

}
