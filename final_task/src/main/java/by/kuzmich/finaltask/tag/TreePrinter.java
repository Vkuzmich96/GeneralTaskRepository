package by.kuzmich.finaltask.tag;

import by.kuzmich.finaltask.bean.Graph;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Set;


public class TreePrinter extends TagSupport {
    private static final long serialVersionUID = 1L;

    private Graph graph;

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            renderRootDiv();
        } catch(IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }
        return SKIP_BODY;
    }

    private void renderRootDiv() throws IOException {
        pageContext.getOut().print("<div id=\"multi-derevo\">");
        pageContext.getOut().print("<h4><a href=\"#\">Ствол дерева</a></h4>");
        renderNode(graph);
    }

    private void renderNode(Graph rootGraph) throws IOException {
        pageContext.getOut().print("<ul>");
            pageContext.getOut().print("<li><span><a href = /action.html?id=\"" +
                    rootGraph.getNode().getId() +
                    "\">" +
                    rootGraph.getNode().getName() +
                    "</a></span>");
            Set<Graph> graphs = rootGraph.getActionSet();
            for (Graph graph : graphs){
                renderNode(graph);
            }
            pageContext.getOut().print("</li>");
        pageContext.getOut().print("</ul>");
    }
}
