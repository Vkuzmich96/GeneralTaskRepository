package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.CommandKind;
import by.kuzmich.finaltask.controller.validator.HttpRequestValidator;
import by.kuzmich.finaltask.controller.validator.ValidatorFactory;
import by.kuzmich.finaltask.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ValidationFilter implements Filter {
    private static Logger logger = Logger.getLogger(ValidationFilter.class);
    /**
     * Contains enum corresponding to the command as key, and URL's for redirect user if request invalid as value
     */
    private static Map<CommandKind, String> redirectUrlMap = new HashMap<>();
    static {
        redirectUrlMap.put(CommandKind.ADD_USER, "/pages/registration.jsp?");
        redirectUrlMap.put(CommandKind.POST_UPDATE_USER_PROFILE, "/profile.html?");
        redirectUrlMap.put(CommandKind.ENTER_USER, "/enter.jsp?");
        redirectUrlMap.put(CommandKind.POST_MAP_NAME, "pages/lawmenu.jsp?");
        redirectUrlMap.put(CommandKind.POST_ACTION, "pages/lawmenu.jsp?");
        redirectUrlMap.put(CommandKind.POST_UPDATE_ACTION, "/updateActionMenu.html?");
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    /**
     * Gets from Validator factory validator's by enum, check's request by the validator method isValid.
     * If request is valid continue's chain, if not redirects user.
     * Use method printParameters for translating error messages and sent wrong parameters in URL parameter's
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        CommandKind command = (CommandKind) req.getAttribute(KeyWordsList.COMMAND);
        HttpRequestValidator validator = ValidatorFactory.getInstance().get(command);
        boolean isValidFlag = false;
        try {
            isValidFlag = validator.isValid(req);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        }
        if (isValidFlag){
            chain.doFilter(req, resp);
        } else {
            req.setAttribute(KeyWordsList.ERROR_MASSAGE, validator.getErrorMap());
            resp.sendRedirect(
                    req.getContextPath()+
                    redirectUrlMap.get(command)+
                    printParameters(validator.getErrorMap())+
                    printParameters(validator.getValidatedParametersMap())
            );
        }
    }

    /**
     * Translate entry's from Map in the URL parameters's
     */
    private String printParameters(Map<String, String> map) throws UnsupportedEncodingException {
        Set<Map.Entry<String, String>> set = map.entrySet();
        if (!set.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : set) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                stringBuilder.append('&');
            }
            return stringBuilder.toString();
        }
        return "";
    }

    @Override
    public void destroy() {}
}
