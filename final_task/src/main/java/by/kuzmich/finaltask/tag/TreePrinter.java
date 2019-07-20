package by.kuzmich.finaltask.tag;

import by.kuzmich.finaltask.bean.Graph;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;


public class TreePrinter extends TagSupport {
    private static final long serialVersionUID = 1L;

    private Graph graph;

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(graph);
        } catch(IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }
        return SKIP_BODY;
    }
}
