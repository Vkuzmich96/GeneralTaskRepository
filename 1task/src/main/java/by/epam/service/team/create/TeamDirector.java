package by.epam.service.team.create;

import by.epam.service.find.Finder;
import by.epam.service.sort.sorter.Sorter;
import by.epam.service.team.create.impl.Var1TeamCreator;

import java.util.HashMap;
import java.util.Map;

public class TeamDirector {
    private Finder finder;
    private Sorter sorter;
    private Map<TeamKey, TeamCreator> teamMap = new HashMap<>();

    public TeamDirector(Finder finder, Sorter sorter){
        this.finder = finder;
        this.sorter = sorter;
        teamMap.put(TeamKey.VAR_1, new Var1TeamCreator(finder, sorter));
    }

    public TeamCreator direct(TeamKey key){
        return teamMap.get(key);
    }
}
