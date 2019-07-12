package by.epam.service.find;

import by.epam.entity.Employee;
import by.epam.entity.Kind;
import by.epam.entity.Position;


import java.util.List;

public interface Finder {
     List<Employee> find(int from, int until);

     List<Employee> find(Kind kind);

     List<Employee> find(Kind kind, Position position);
}