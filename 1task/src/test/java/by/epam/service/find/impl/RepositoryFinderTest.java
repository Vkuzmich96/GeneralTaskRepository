package by.epam.service.find.impl;

import by.epam.entity.Kind;
import by.epam.entity.Position;
import by.epam.repository.impl.EmployeeRepository;
import by.epam.service.ServiceException;
import by.epam.service.find.Finder;
import by.epam.service.handle.Handler;
import by.epam.service.handle.HandlerFactory;
import by.epam.service.handle.HandlerKey;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class RepositoryFinderTest {
    private Handler handler = HandlerFactory.getInstance().getHandler(HandlerKey.FILE_HANDLER);
    private EmployeeRepository repository = EmployeeRepository.getInstance();
    private Finder finder = new RepositoryFinder(repository);

    public RepositoryFinderTest() throws ServiceException {
        repository.addAll(handler.handle("TestValues.txt"));
    }

    @Before
    public void prepare() throws ServiceException {
        repository.get().clear();
        repository.addAll(handler.handle("TestValues.txt"));
    }

    @Test
    public void findByKind() {
        int actual = finder.find(Kind.DEVELOPER).size();
        int expected = 9;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findBySalary(){
        int actual =  finder.find(200, 400).size();
        int expected = 6;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findByKindAndPosition(){
        int actual = finder.find(Kind.DEVELOPER, Position.JUNIOR).size();
        int expected = 5;
        Assert.assertEquals(expected,actual);

    }
}