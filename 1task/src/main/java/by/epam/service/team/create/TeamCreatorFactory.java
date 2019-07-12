package by.epam.service.team.create;

import by.epam.service.find.FinderFactory;
import by.epam.service.find.FinderKey;
import by.epam.service.sort.sorter.SortFactory;
import by.epam.service.sort.sorter.SortKey;
import by.epam.service.team.create.impl.Var1TeamCreator;

import java.util.HashMap;
import java.util.Map;

public class TeamCreatorFactory {

    private static final TeamCreatorFactory factory = new TeamCreatorFactory();
    private Map<TeamKey, TeamCreator> map = new HashMap<>();

    public static TeamCreatorFactory getInstance(){
        return factory;
    }

    public TeamCreator getTeamCreator(TeamKey key){
        return map.get(key);
    }

    private TeamCreatorFactory(){
        map.put(TeamKey.VAR_1,
                new Var1TeamCreator(
                        FinderFactory.getInstance().getFinder(FinderKey.REPOSITORY_FINDER),
                        SortFactory.getInstance().getSorter(SortKey.INSERT)
                )
        );
    }
}
