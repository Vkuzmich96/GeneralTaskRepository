package by.epam.controller;

import by.epam.controller.builder.BuilderChainFactory;
import by.epam.controller.builder.BuilderKey;
import by.epam.controller.parser.ParserFactory;
import by.epam.controller.parser.ParserKey;
import by.epam.service.ShowServiceFactory;
import by.epam.service.ShowServiceKey;
import by.epam.service.SortServiceFactory;
import by.epam.service.SortServiceKey;
import by.epam.service.composit.Ellyment;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {
    private static ControllerFactory factory = new ControllerFactory();

    public static ControllerFactory getInstance(){
        return factory;
    }

    private Map<ControllerKey, Controller> map = new HashMap<>();

    private ControllerFactory(){
        map.put(ControllerKey.ELLYMENT_CONTROLLER,
                new EllymentController(
                        ParserFactory.getInstance().get(ParserKey.ELLYMENT_PARSER),
                        BuilderChainFactory.getInstance().get(BuilderKey.TEXT_PARSER),
                        ShowServiceFactory.getInstance().get(ShowServiceKey.SHOW_ELLYMENT_SERVICE_KEY),
                        SortServiceFactory.getInstance().get(SortServiceKey.SORT_ELLYMENT_SERVICE_KEY)
                )
        );
    }

    public Controller get (ControllerKey key){
        return map.get(key);
    }
}
