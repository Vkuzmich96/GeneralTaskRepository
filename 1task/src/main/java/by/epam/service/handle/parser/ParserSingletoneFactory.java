package by.epam.service.handle.parser;

import by.epam.service.handle.parser.impl.FileParser;

import java.util.HashMap;
import java.util.Map;

public class ParserSingletoneFactory {

    private  Map<ParserKey, Parser> parserMap;

    public static ParserSingletoneFactory getInstance(){
        return SingletoneHolder.factory;
    }

    public Parser getParser(ParserKey parserKey) {
        return parserMap.get(parserKey);
    }

    private ParserSingletoneFactory(){
        parserMap = new HashMap<>();
        parserMap.put(ParserKey.FILE_PARSER, new FileParser());
    }

    private static class SingletoneHolder {
        private static ParserSingletoneFactory factory;
        static {
            factory = new ParserSingletoneFactory();
        }
    }
}
