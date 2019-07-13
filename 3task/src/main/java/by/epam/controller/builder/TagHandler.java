package by.epam.controller.builder;

import by.epam.bean.Candy;

public interface TagHandler {
    void handle(Candy candy, String tag, String value);
}
