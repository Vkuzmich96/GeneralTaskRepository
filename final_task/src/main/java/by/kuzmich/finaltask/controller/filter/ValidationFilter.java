package by.kuzmich.finaltask.controller.filter;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.command.CommandKind;
import by.kuzmich.finaltask.controller.validator.Validator;
import by.kuzmich.finaltask.controller.validator.ValidatorFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ValidationFilter implements Filter {
    private static Map<CommandKind, String> forwardMap = new HashMap<>();
    static {
        forwardMap.put(CommandKind.ADD_USER, "/pages/registration.jsp");
        forwardMap.put(CommandKind.ENTER_USER, "/enter.jsp");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        CommandKind command = (CommandKind) req.getAttribute(KeyWordsList.COMMAND);
        Validator validator = ValidatorFactory.getInstance().get(command);
        boolean isValidFlag = validator.isValid(req);
        if (isValidFlag){
            chain.doFilter(req, resp);
        } else {
            req.setAttribute(KeyWordsList.ERROR_MASSAGE, validator.getErrorMap());
            req.getServletContext().getRequestDispatcher(forwardMap.get(command)).forward(req, resp);
        }

    }

    @Override
    public void destroy() {

    }
}
