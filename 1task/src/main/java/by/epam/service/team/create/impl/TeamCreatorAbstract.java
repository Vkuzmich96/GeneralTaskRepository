package by.epam.service.team.create.impl;

import by.epam.entity.Employee;
import by.epam.entity.Kind;
import by.epam.entity.Position;
import by.epam.entity.Team;
import by.epam.service.find.Finder;
import by.epam.service.sort.comparator.SalaryComparator;
import by.epam.service.sort.sorter.Sorter;
import by.epam.service.team.count.Counter;
import by.epam.service.team.create.TeamCreator;

import java.util.ArrayList;
import java.util.List;

public abstract class TeamCreatorAbstract implements TeamCreator {
    private Finder finder;
    private Sorter sorter;

    public TeamCreatorAbstract(Finder finder, Sorter sorter) {
        this.finder = finder;
        this.sorter = sorter;
    }

    public abstract Team create();

    protected void addEmployees(List<Employee> employees, Kind kind, Position position, int quantity){
        List<Employee> finded = finder.find(kind, position);
        sorter.sort(finded, new SalaryComparator());
        employees.addAll(getBestEmployees(finded,quantity));
    }

    private List<Employee> getBestEmployees (List<Employee> employees, int quantity){
        List<Employee> best = new ArrayList<>();
        for (int i = 0; i < employees.size() && i < quantity; i++){
            best.add(employees.get(i));
        }
        return best;
    }
}
