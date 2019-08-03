package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.bean.LawMapName;
import by.kuzmich.finaltask.exception.ServiceException;

import java.util.List;

public interface LawMapNameService {
    List<LawMapName> getAll() throws ServiceException;
    int add (LawMapName name) throws ServiceException;
}
