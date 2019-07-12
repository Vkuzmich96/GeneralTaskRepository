package by.epam.service.sort.sorter;

import by.epam.service.sort.sorter.impl.InsertSort;

import java.util.HashMap;
import java.util.Map;

public class SortFactory {
    private static final SortFactory factory = new SortFactory();
    public static SortFactory  getInstance(){
        return factory;
    }
    private Map<SortKey, Sorter> map;

    private SortFactory(){
        map = new HashMap<>();
        map.put(SortKey.INSERT, new InsertSort());
    }

    public Sorter getSorter(SortKey key){
        return map.get(key);
    }
}
