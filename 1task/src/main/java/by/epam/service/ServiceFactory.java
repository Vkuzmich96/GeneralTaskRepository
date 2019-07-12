package by.epam.service;

import by.epam.repository.impl.EmployeeRepository;
import by.epam.service.find.FinderFactory;
import by.epam.service.find.FinderKey;
import by.epam.service.handle.HandlerKey;
import by.epam.service.handle.HandlerFactory;
import by.epam.service.sort.sorter.SortFactory;
import by.epam.service.sort.sorter.SortKey;
import by.epam.service.team.count.CounterFactory;
import by.epam.service.team.count.CounterKey;
import by.epam.service.team.create.TeamCreatorFactory;
import by.epam.service.team.create.TeamKey;

import java.util.HashMap;
import java.util.Map;


public class ServiceFactory {

    private static final ServiceFactory factory = new ServiceFactory();

    private Map<ServiceKey, Service> map = new HashMap<>();

    public static ServiceFactory getInstance(){
        return factory;
    }

    private ServiceFactory(){
        map.put(ServiceKey.GENERAL,
                new GeneralService(
                        FinderFactory.getInstance().getFinder(FinderKey.REPOSITORY_FINDER),
                        HandlerFactory.getInstance().getHandler(HandlerKey.FILE_HANDLER),
                        SortFactory.getInstance().getSorter(SortKey.INSERT),
                        TeamCreatorFactory.getInstance().getTeamCreator(TeamKey.VAR_1),
                        EmployeeRepository.getInstance(),
                        CounterFactory.getInstance().get(CounterKey.MANS_HOURS_SALARY)
                )
        );
    }


    public Service getGeneralService(ServiceKey key){
        return map.get(key);
    }
}
