package by.kuzmich.finaltask.tag;

import by.kuzmich.finaltask.bean.Action;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class ActionPrinter  extends TagSupport {
    private static final long serialVersionUID = 1L;

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
        pageContext.getOut().print("<h4>"+action+"</h4>");
    }

}
