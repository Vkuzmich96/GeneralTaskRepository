package by.epam.service.handle.creator.chain;

import by.epam.entity.Employee;
import by.epam.entity.developer.Developer;
import by.epam.entity.tester.Tester;
import by.epam.service.ServiceException;
import jdk.Exported;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CreatorChainTest {
    private CreatorChain<Employee> creator = CreatorFactory.getInstance().getCreator(CreatorKey.EMPLOYEE_CREATOR);
    private String[] developerString = "developer;senior;java;Misha;5;2500".split(";");
    private String[] testerString = "tester;junior;hand;Simon;1;210".split(";");
    private String[] invalidData = "testnior;hand;Simon;1;210".split(";");

    @Test
    public void createDeveloper() throws ServiceException {
        Developer developer = (Developer) creator.create(developerString);
        Assert.assertNotNull(developer);
    }

    @Test
    public void createTester() throws ServiceException {
        Tester tester = (Tester) creator.create(testerString);
        System.out.println(tester);
    }

    @Test(expected = ServiceException.class)
    public void setInvalidData() throws ServiceException {
            creator.create(invalidData);
    }
}