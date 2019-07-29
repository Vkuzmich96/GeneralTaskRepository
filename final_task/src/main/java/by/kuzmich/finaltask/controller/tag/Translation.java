package by.kuzmich.finaltask.controller.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Translation extends TagSupport{
    private static final long serialVersionUID = 1L;

    public int doStartTag() throws JspException {
        ResourceBundle bundle = ResourceBundle.getBundle("label_ru", new Locale("ru", "RU"));
        ResourceBundle bundleEn = ResourceBundle.getBundle("label_en", new Locale("en", "US"));

        try {
            pageContext.getOut().print(pageContext.getRequest().getLocale());
            pageContext.getOut().print(bundle.getString("welcome"));
            pageContext.getOut().print(bundleEn.getString("welcome"));
        } catch(IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }
}
