package by.epam.service.find.specification.impl;

import by.epam.entity.Employee;
import by.epam.entity.Kind;
import by.epam.service.find.specification.Specification;

public class FindByKindSpecification implements Specification<Employee> {

    private Kind kind;

    public FindByKindSpecification(Kind kind) {
        this.kind = kind;
    }

    @Override
    public boolean match(Employee bean) {
        Kind kind = bean.getKind();
        return this.kind==kind;
    }
}
