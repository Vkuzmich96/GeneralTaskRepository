package by.kuzmich.finaltask.tag;

import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.controller.KeyWordsList;

import java.io.IOException;

public class MenuPrinter extends Tag {

    public void renderRootDiv() throws IOException {
        pageContext.getOut().print("<div>");
            pageContext.getOut().print(String.format("<p> %s </p>", pageContext.getSession().getAttribute(KeyWordsList.LOGIN)));
            pageContext.getOut().print("<form action=\"/logout.html\">");
                pageContext.getOut().print("<input type=\"submit\" value=\"logout\">");
            pageContext.getOut().print("</form>");
            renderLawerForm();
        pageContext.getOut().print("</div>");
    }

    private void renderLawerForm() throws IOException {
        Role roleFromSession = (Role) pageContext.getSession().getAttribute(KeyWordsList.ROLE);
        if (Role.LAWER.equals(roleFromSession)){
            pageContext.getOut().print("<form action=\"/lawermenu.html\">");
                pageContext.getOut().print("<input type=\"submit\" value=\"lawer menu\">");
            pageContext.getOut().print("</form>");
        }
    }

}
