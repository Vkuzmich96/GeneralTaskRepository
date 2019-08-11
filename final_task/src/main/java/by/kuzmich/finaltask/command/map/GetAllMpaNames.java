package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.LawMapNameService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllMpaNames extends Command {
    private LawMapNameService nameService;

    public GetAllMpaNames(LawMapNameService nameService) {
        this.nameService = nameService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        req.setAttribute("maps", nameService.getAll());
        return PagePathList.NAME_LIST_FORWARDED;
    }
}
