package by.kuzmich.finaltask.controller.tag;

import by.kuzmich.finaltask.bean.Graph;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.MapService;
import by.kuzmich.finaltask.service.MapServiceFactory;
import by.kuzmich.finaltask.service.impl.ActionServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Set;


public class TreePrinter extends TagSupport {
    private static Logger logger = Logger.getLogger(TreePrinter.class);
    private static final long serialVersionUID = 1L;
    private MapService service = MapServiceFactory.getInstance().get();
    private String number;

    public void setNumber(String number) {
        this.number = number;
    }

    public int doStartTag() throws JspException {
        try {
            renderRootDiv();
        } catch(IOException | ServiceException e) {
            logger.error(e.getMessage());
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }


    private void renderRootDiv() throws IOException, ServiceException {
        Graph graph = service.get(number);
        pageContext.getOut().print("<link href=\"../support/lawmap_style.css\" rel=\"stylesheet\" type=\"text/css\">");
        pageContext.getOut().print("<div id=\"multi-derevo list-group\">");
        pageContext.getOut().print(String.format("<h4> %s </h4>", graph.getName()));
        if (graph.getActionSet()!=null) {
            renderNode(graph);
        }
    }

    private void renderNode(Graph rootGraph) throws IOException {
        pageContext.getOut().print("<ul>");
            pageContext.getOut().print(
                    String.format("<li ><span><a href = /action.html?id=%s class=\"list-group-item\"> %s </a></span>",
                            rootGraph.getNode().getId(),
                            rootGraph.getNode().getName()
                    )
            );
            Set<Graph> graphs = rootGraph.getActionSet();
            for (Graph graph : graphs){
                renderNode(graph);
            }
            pageContext.getOut().print("</li>");
        pageContext.getOut().print("</ul>");
    }
}
