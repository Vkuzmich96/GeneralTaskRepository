package by.epam.controller.parser;

import by.epam.controller.parser.impl.FileParser;

import java.util.HashMap;
import java.util.Map;

public class ParserFactory {
    private static ParserFactory factory = new ParserFactory();

    public static ParserFactory getInstance(){
        return factory;
    }

    private Map<ParserKey, Parser> map = new HashMap<>();

    private ParserFactory(){
        map.put(ParserKey.ELLYMENT_PARSER, new FileParser());
    }

    public Parser get (ParserKey key){
        return map.get(key);
    }

}
