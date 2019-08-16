package by.kuzmich.finaltask.command.map;

import by.kuzmich.finaltask.KeyWordsList;
import by.kuzmich.finaltask.bean.LawMapName;
import by.kuzmich.finaltask.command.Command;
import by.kuzmich.finaltask.command.PagePathList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.LawMapNameService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class GetAllMpaNames extends Command {
    private LawMapNameService nameService;
    private static final String MAPS = "maps";
    private static final int MAX_NUMBER_OF_NAMES_ON_ONE_PAGE = 8;
    private static final String NUMBER_OF_PAGES = "numberOfPages";
    public GetAllMpaNames(LawMapNameService nameService) {
        this.nameService = nameService;
    }

    /**
     * Gets all LawMapName objects from service.
     * Calculates number of pages.
     * Puts a collection of names suitable for the page size in request attribute MAPS.
     * Puts a number of pages in request attribute NUMBER_OF_PAGES.
     */
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String number = req.getParameter(KeyWordsList.NUMBER);
        List<LawMapName> maps =  nameService.getAll();
        List<LawMapName> mapsForResponse = new ArrayList<>();
        int start = number == null ? 0 : MAX_NUMBER_OF_NAMES_ON_ONE_PAGE * Integer.parseInt(number);
        for (int i = start, j = 0; i < (maps.size()) && j < MAX_NUMBER_OF_NAMES_ON_ONE_PAGE; i++, j++){
            mapsForResponse.add(maps.get(i));
        }
        double size = maps.size();
        int numberOfPages = (int) Math.ceil(size / MAX_NUMBER_OF_NAMES_ON_ONE_PAGE) -1;
        req.setAttribute(MAPS, mapsForResponse);
        req.setAttribute(NUMBER_OF_PAGES, numberOfPages);
        return PagePathList.NAME_LIST_FORWARDED;
    }
}
