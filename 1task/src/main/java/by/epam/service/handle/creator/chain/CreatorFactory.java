package by.epam.service.handle.creator.chain;

import by.epam.entity.Employee;
import by.epam.service.handle.creator.chain.impl.DeveloperCreator;
import by.epam.service.handle.creator.chain.impl.InvalidDataCase;
import by.epam.service.handle.creator.chain.impl.TesterCreator;

import java.util.HashMap;
import java.util.Map;

public class CreatorFactory {
    private static final CreatorFactory factory = new CreatorFactory();

    private Map<CreatorKey, CreatorChain<Employee>> creatorMap = new HashMap<>();

    private CreatorFactory(){
        creatorMap.put(CreatorKey.EMPLOYEE_CREATOR, createEmployeeCreator());
    }

    public static CreatorFactory getInstance(){
        return factory;
    }

    public CreatorChain<Employee> getCreator(CreatorKey key){
        return creatorMap.get(key);
    }

    private CreatorChain<Employee> createEmployeeCreator(){
        return new InvalidDataCase()
                .linkWith(new TesterCreator())
                .linkWith(new DeveloperCreator());
    }

}
