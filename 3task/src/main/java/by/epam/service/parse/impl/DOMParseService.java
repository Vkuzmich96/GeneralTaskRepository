package by.epam.service.parse.impl;

import by.epam.bean.Candy;
import by.epam.controller.builder.BuilderFactory;
import by.epam.controller.builder.BuilderKey;
import by.epam.controller.builder.impl.Director;
import by.epam.controller.builder.impl.DomBuilder;
import by.epam.service.parse.Parser;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public class DOMParseService implements Parser {
    private DomBuilder domBuilder = (DomBuilder) BuilderFactory.getInstance().getBuilder(BuilderKey.DOM);

    @Override
    public List<Candy> parse(String url) {
        List<Candy> candyList = null;
        try {
            candyList = Director.build(url, domBuilder);
        } catch (SAXException | IOException | XMLStreamException e) {
            e.printStackTrace();
        }

        return candyList;
    }
}
