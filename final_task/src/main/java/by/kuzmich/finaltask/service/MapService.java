package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.bean.Graph;
import by.kuzmich.finaltask.bean.GraphEdge;

import java.sql.SQLException;

public interface MapService {
    Graph get (String number);
    int addEdge(GraphEdge edge) throws SQLException;
}
