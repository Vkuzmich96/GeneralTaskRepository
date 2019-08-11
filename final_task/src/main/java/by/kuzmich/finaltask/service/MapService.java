package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.bean.Graph;
import by.kuzmich.finaltask.bean.GraphEdge;
import by.kuzmich.finaltask.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface MapService {
    Graph get (String number) throws ServiceException;
    int addEdge(GraphEdge edge) throws ServiceException;
    List<GraphEdge> getAll(String key) throws ServiceException;
}
