package by.epam.service.team.count;

import by.epam.entity.Employee;
import by.epam.service.ServiceException;
import by.epam.service.handle.creator.chain.CreatorChain;
import by.epam.service.handle.creator.chain.CreatorFactory;
import by.epam.service.handle.creator.chain.CreatorKey;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CounterTest {
    private CreatorChain<Employee> chain = CreatorFactory.getInstance().getCreator(CreatorKey.EMPLOYEE_CREATOR);
    private List<Employee> list = new ArrayList<>();
    private Counter counter = CounterFactory.getInstance().get(CounterKey.MANS_HOURS_SALARY);

    @Before
    public void prepare() throws ServiceException {
        list.add(chain.create("developer;junior;java;Vasya;1;100".split(";")));
        list.add(chain.create("developer;junior;java;Vasya;1;100".split(";")));
        list.add(chain.create("developer;junior;java;Vasya;1;100".split(";")));
    }

    @Test
    public void count() {
        int actual = counter.count(list);
        int expected = 300;
        assertEquals(expected,actual);
    }
}