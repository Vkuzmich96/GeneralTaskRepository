package by.epam.service.find.impl;

import by.epam.entity.Employee;
import by.epam.entity.Kind;
import by.epam.entity.Position;
import by.epam.repository.Repository;
import by.epam.service.find.Finder;
import by.epam.service.find.specification.impl.FindByKindAndPositionSpecification;
import by.epam.service.find.specification.impl.FindByKindSpecification;
import by.epam.service.find.specification.impl.FindBySalarySpecification;
import java.util.List;


public class RepositoryFinder implements Finder {
    private Repository repository;

    public RepositoryFinder(Repository repository){
        this.repository = repository;
    }

    public List<Employee> find(int from, int until){
        return repository.find(new FindBySalarySpecification(from, until));
    }

    public List<Employee> find(Kind kind){
        return repository.find(new FindByKindSpecification(kind));
    }

    public List<Employee> find(Kind kind, Position position){
        return repository.find(new FindByKindAndPositionSpecification(kind, position));
    }
}
