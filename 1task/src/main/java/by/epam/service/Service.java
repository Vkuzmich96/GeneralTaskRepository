package by.epam.service;

import by.epam.entity.Employee;

import java.util.List;

public interface Service {
    List<Employee> find(String from, String until) throws ServiceException;
    void handle(String path) throws ServiceException;
    String sort(String key);
    String create();
}
