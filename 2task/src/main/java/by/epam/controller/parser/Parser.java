package by.epam.controller.parser;

import by.epam.controller.ControllerException;

import java.nio.file.Path;

public interface Parser {
    String parse(Path path) throws ControllerException;
}
