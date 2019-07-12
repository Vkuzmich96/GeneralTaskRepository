package by.epam.service.team.count.impl;

import by.epam.entity.Employee;
import by.epam.service.team.count.Counter;

import java.util.List;

public class CountManHoursSalary implements Counter {

    @Override
    public int count(List<Employee> list) {
        int result = 0;
        for (Employee employee : list) {
            result += employee.getSalary();
        }
        return result;
    }
}
