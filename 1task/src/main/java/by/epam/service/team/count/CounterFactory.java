package by.epam.service.team.count;

import by.epam.service.team.count.impl.CountManHoursSalary;

import java.util.HashMap;
import java.util.Map;

public class CounterFactory {

    private static final CounterFactory factory = new CounterFactory();

    private Map<CounterKey, Counter> map = new HashMap<>();

    public static CounterFactory getInstance(){
        return factory;
    }

    public Counter get(CounterKey key){
        return map.get(key);
    }

    private CounterFactory(){
        map.put(CounterKey.MANS_HOURS_SALARY, new CountManHoursSalary());
    }

}
