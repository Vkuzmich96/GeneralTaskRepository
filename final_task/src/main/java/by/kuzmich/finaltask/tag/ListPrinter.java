package by.kuzmich.finaltask.tag;

import by.kuzmich.finaltask.bean.LawMapName;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class ListPrinter extends TagSupport {
    private static final long serialVersionUID = 1L;

    private List<LawMapName> names;

    public void setNames(List<LawMapName> names) {
        this.names = names;
    }

    public int doStartTag() throws JspException {
        try {
            renderRootDiv();
        } catch(IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }

    private void renderRootDiv() throws IOException {
        for (LawMapName name : names){
            pageContext.getOut().print(
                    "<li><span><a href = /lawmap.html?number=" + name.getId() + ">" + name.getName() + "</a></span>"
            );
        }
    }
}
