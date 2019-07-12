package by.epam.repository.impl;

import by.epam.repository.Repository;
import by.epam.entity.Employee;
import by.epam.service.find.specification.Specification;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {
    private static final EmployeeRepository employeeRepository = new EmployeeRepository();
    private List<Employee> repository = new ArrayList<>();

    private EmployeeRepository(){
    }

    public static EmployeeRepository getInstance(){
        return employeeRepository;
    }

    @Override
    public void add(Employee bean) {
        repository.add(bean);
    }

    @Override
    public void addAll(List<Employee> beans) {
        repository.addAll(beans);
    }

    @Override
    public List<Employee> get() {
        return repository;
    }

    @Override
    public List find(Specification spec) {
        List<Employee> employeeList = new ArrayList<>();
        for(Employee employee : repository) {
            if (spec.match(employee)){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Employees{");
        string.append('\n');
        for (Employee employee : repository){
            string.append(" employee - ").append(employee).append('\n');
        }
        string.append('}');
        return string.toString();
    }
}
