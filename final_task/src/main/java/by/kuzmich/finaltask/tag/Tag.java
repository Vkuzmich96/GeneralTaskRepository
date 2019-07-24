package by.kuzmich.finaltask.tag;

import javax.servlet.jsp.JspException;
import java.io.IOException;
import javax.servlet.jsp.tagext.TagSupport;

public abstract class Tag extends TagSupport {
    private static final long serialVersionUID = 1L;
    public int doStartTag() throws JspException {
        try {
            renderRootDiv();
        } catch(IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }

    public abstract void renderRootDiv() throws IOException;
}
