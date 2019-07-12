package by.epam.service.find.specification;

@FunctionalInterface
public interface Specification <T> {
    boolean match(T bean);
}
