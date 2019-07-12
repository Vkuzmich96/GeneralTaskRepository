package by.epam.controller.builder;


import by.epam.controller.ControllerException;

public interface ChainEllyment<T> extends Builder {
     T linkWith (T builder) throws ControllerException;
}
