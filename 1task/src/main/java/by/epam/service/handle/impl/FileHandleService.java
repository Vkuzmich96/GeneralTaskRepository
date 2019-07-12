package by.epam.service.handle.impl;

import by.epam.entity.Employee;
import by.epam.service.ServiceException;
import by.epam.service.handle.Handler;
import by.epam.service.handle.creator.chain.CreatorChain;
import by.epam.service.handle.parser.Parser;
import by.epam.service.handle.validator.ValidationResult;
import by.epam.service.handle.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class FileHandleService implements Handler {
    private Parser parser;
    private Validator validator;
    private CreatorChain<Employee> creator;

    public FileHandleService(Parser parser, Validator validator, CreatorChain<Employee> creator) {
        this.parser = parser;
        this.validator = validator;
        this.creator = creator;
    }

    @Override
    public List<Employee> handle(String path) throws ServiceException {
        List<String[]> stringList = parser.parse(path);
        ValidationResult result = validator.valid(stringList);
        List<Employee> employees ;
        if (result.isValid()){
            employees = transform(stringList);
        } else {
            throw new ServiceException("file is invalid" + result.toString());
        }
        return employees;
    }

    private List<Employee> transform( List<String[]> stringList) throws ServiceException {
        List<Employee> employees = new ArrayList<>();
        for (String[] strings: stringList){
            employees.add(creator.create(strings));
        }
        return employees;
    }

}
