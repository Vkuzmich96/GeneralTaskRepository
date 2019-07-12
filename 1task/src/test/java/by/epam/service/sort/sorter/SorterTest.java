package by.epam.service.sort.sorter;

import by.epam.entity.Employee;
import by.epam.service.ServiceException;
import by.epam.service.handle.Handler;
import by.epam.service.handle.HandlerFactory;
import by.epam.service.handle.HandlerKey;
import by.epam.service.sort.comparator.ExperienceComparator;
import by.epam.service.sort.comparator.SalaryComparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SorterTest {
    private Sorter<Employee> sorter = SortFactory.getInstance().getSorter(SortKey.INSERT);
    private List<Employee> employees;

    @Before
    public void prepare() throws ServiceException {
        employees = HandlerFactory.getInstance().getHandler(HandlerKey.FILE_HANDLER).handle("TestValues.txt");
    }

    @After
    public void clear(){
        employees.clear();
    }

    @Test
    public void sortBySalary(){
        sorter.sort(employees, new SalaryComparator());
        for (int i = 0; i < employees.size()-1; i++) {
            if (employees.get(i).getSalary() > employees.get(i+1).getSalary()){
                fail();
            }
        }
    }

    @Test
    public void sortByExperience(){
        sorter.sort(employees, new ExperienceComparator());
        for (int i = 0; i < employees.size()-1; i++) {
            if (employees.get(i).getExperience() > employees.get(i+1).getExperience()){
                fail();
            }
        }
    }
}