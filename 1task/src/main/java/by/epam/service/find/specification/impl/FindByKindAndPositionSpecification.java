package by.epam.service.find.specification.impl;

import by.epam.entity.Employee;
import by.epam.entity.Kind;
import by.epam.entity.Position;
import by.epam.service.find.specification.Specification;

public class FindByKindAndPositionSpecification implements Specification<Employee> {

    private Kind kind;
    private Position position;

    public FindByKindAndPositionSpecification(Kind kind, Position position) {
        this.kind = kind;
        this.position = position;
    }

    @Override
    public boolean match(Employee bean) {
        return kind==bean.getKind()&&position==bean.getPosition();
    }
}
