package by.epam.service.find;

import by.epam.repository.impl.EmployeeRepository;
import by.epam.service.find.impl.RepositoryFinder;

import java.util.HashMap;
import java.util.Map;

public class FinderFactory {
    private static final FinderFactory factory = new FinderFactory();
    private Map<FinderKey, Finder> map = new HashMap<>();

    public static FinderFactory getInstance() {
        return factory;
    }

    public Finder getFinder(FinderKey key){
        return map.get(key);
    }

    private FinderFactory(){
        map.put(FinderKey.REPOSITORY_FINDER, new RepositoryFinder(EmployeeRepository.getInstance())
        );
    }
}
