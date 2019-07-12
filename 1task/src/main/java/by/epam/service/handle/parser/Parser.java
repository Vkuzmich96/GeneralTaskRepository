package by.epam.service.handle.parser;

import by.epam.service.ServiceException;

import java.util.List;

public interface Parser {
    List<String[]> parse(String path) throws ServiceException;
}
