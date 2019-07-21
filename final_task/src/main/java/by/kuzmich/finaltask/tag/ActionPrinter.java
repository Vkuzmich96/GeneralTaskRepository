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
        pageContext.getOut().print("<h4>" + action.getName() + "</h4>");
        pageContext.getOut().print("<p>" + action.getInstructions() + "</p>");
        for (Material material : action.getMaterials()) {
            pageContext.getOut().print("<p>" + material.getDiscription() + "</p>");
            pageContext.getOut().print(
                    "<a href =" + prefix +  material.getUrl() + ">" + "download" + "</a>"
            );
        }
        pageContext.getOut().print("</div>");

    }

}
