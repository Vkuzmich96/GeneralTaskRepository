package by.epam.service.handle;

import by.epam.entity.Employee;
import by.epam.service.ServiceException;

import java.util.List;

public interface Handler {
    List<Employee> handle(String path) throws ServiceException;
}
