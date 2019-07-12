package by.epam.controller;

import by.epam.service.composit.Ellyment;

public interface Controller {
    Ellyment read(String path) throws ControllerException;
    void sort();
    String show();
}
