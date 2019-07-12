package by.epam.service;

import by.epam.entity.Employee;
import by.epam.entity.Team;
import by.epam.repository.Repository;
import by.epam.service.find.Finder;
import by.epam.service.handle.Handler;
import by.epam.service.sort.comparator.ExperienceComparator;
import by.epam.service.sort.comparator.SalaryComparator;
import by.epam.service.sort.sorter.Sorter;
import by.epam.service.team.count.Counter;
import by.epam.service.team.create.TeamCreator;

import java.util.List;

public class GeneralService implements Service {

    private Finder finder;
    private Handler handler;
    private Sorter sorter;
    private TeamCreator creator;
    private Repository repository;
    private Counter counter;

    public GeneralService(Finder finder, Handler handler, Sorter sorter, TeamCreator creator, Repository repository, Counter counter) {
        this.finder = finder;
        this.handler = handler;
        this.sorter = sorter;
        this.creator = creator;
        this.repository = repository;
        this.counter = counter;
    }

    @Override
    public List<Employee> find(String from, String until) throws ServiceException {
        try {
            return finder.find(Integer.parseInt(from), Integer.parseInt(until));
        }catch (NumberFormatException e){
            throw new ServiceException("wrong type of entered arguments", e);
        }
    }

    @Override
    public void handle(String path) throws ServiceException {
        repository.addAll(handler.handle(path));
    }

    @Override
    public String sort(String key) {
        switch (key){
            case "salary":
                sorter.sort(repository.get(), new SalaryComparator());
                break;
            case "experience":
                sorter.sort(repository.get(), new ExperienceComparator());
                break;
        }
        return repository.toString();
    }

    @Override
    public String create() {
        Team team = creator.create();
        return team.toString()+ '\n' + "Man hours" + counter.count(team.getEmployees());
    }
}
