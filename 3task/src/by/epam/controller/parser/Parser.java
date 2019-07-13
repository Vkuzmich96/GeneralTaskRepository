package by.epam.controller.parser;

import by.epam.bean.Candy;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public interface Parser {
    List<Candy> parse() throws IOException, SAXException;
}
