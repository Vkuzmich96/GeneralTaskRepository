package by.epam.controller;

import by.epam.controller.Controller;
import by.epam.controller.builder.Builder;
import by.epam.controller.parser.Parser;
import by.epam.service.ShowService;
import by.epam.service.SortService;
import by.epam.service.composit.Ellyment;

import java.nio.file.Paths;

public class EllymentController implements Controller {
    private Parser parser;
    private Builder<Ellyment> builder;
    private ShowService showService;
    private SortService sortService;
    private Ellyment ellyment;

    public EllymentController(Parser parser, Builder<Ellyment> builder, ShowService showService, SortService sortService) {
        this.parser = parser;
        this.builder = builder;
        this.showService = showService;
        this.sortService = sortService;
    }

    @Override
    public Ellyment read(String path) throws ControllerException {
        String text = parser.parse(Paths.get(path));
        ellyment = builder.build(text);
        return ellyment;
    }

    @Override
    public void sort() {
        sortService.sort(ellyment);
    }

    @Override
    public String show() {
        return showService.get(ellyment);
    }
}
