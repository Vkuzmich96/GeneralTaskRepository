package by.epam.service.handle.creator.chain;

import by.epam.entity.Employee;
import by.epam.service.ServiceException;
import by.epam.service.handle.FileArgumentConstants;

import java.util.UUID;

public abstract class EmployeeCreator implements CreatorChain<Employee> {

    private EmployeeCreator next;

    @Override
    public CreatorChain<Employee> linkWith(CreatorChain<Employee> next){
        ((EmployeeCreator) next).next = this;
        return next;
    }

    protected Employee nextParse(String[] strings) throws ServiceException {
        return next != null ? next.create(strings) : null;
    }

    private int idMaker(){
        return UUID.randomUUID().hashCode();
    }

    protected Employee build(Employee employee, String[] strings) {
        employee.setName(strings[FileArgumentConstants.NAME_ARGUMENT]);
        employee.setExperience(Integer.parseInt(strings[FileArgumentConstants.EXPERIENCE_ARGUMENT]));
        employee.setSalary(Integer.parseInt(strings[FileArgumentConstants.SALARY_ARGUMENT]));
        employee.setId(idMaker());
        return employee;
    }
}
