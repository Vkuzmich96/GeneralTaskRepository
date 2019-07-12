package by.epam.service.handle.creator.chain.impl;

import by.epam.entity.Employee;
import by.epam.service.ServiceException;
import by.epam.service.handle.creator.chain.EmployeeCreator;

public class InvalidDataCase extends EmployeeCreator {
    @Override
    public Employee create(String[] strings) throws ServiceException {
        throw new ServiceException("trying create invalid Employee");
    }
}
