package by.epam.repository;

import by.epam.service.find.specification.Specification;

import java.util.List;


public interface Repository<T> {
    List<T> find (Specification<T> spec);
    void add(T bean);
    void addAll(List<T> beans);
    List<T> get ();
}
