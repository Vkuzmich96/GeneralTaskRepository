package by.kuzmich.finaltask.tag;

import by.kuzmich.finaltask.bean.LawMapName;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class ListPrinter extends Tag {

    private List<LawMapName> names;

    public void setNames(List<LawMapName> names) {
        this.names = names;
    }

    public void renderRootDiv() throws IOException {
        for (LawMapName name : names){
            pageContext.getOut().print(
                    String.format("<li><span><a href = /lawmap.html?number=%s> %s </a></span>", name.getId(), name.getName())
            );
        }
    }
}
