package by.epam.service.parse.impl;

import by.epam.bean.Candy;
import by.epam.controller.builder.BuilderFactory;
import by.epam.controller.builder.BuilderKey;
import by.epam.controller.builder.impl.Director;
import by.epam.controller.builder.impl.SaxBuilder;
import by.epam.service.parse.Parser;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public class SAXParserService implements Parser {
    private SaxBuilder saxBuilder = (SaxBuilder) BuilderFactory.getInstance().getBuilder(BuilderKey.SAX);

    @Override
    public List<Candy> parse(String url) {
        List<Candy> candiesList = null;
        try {
            candiesList = Director.build(url, saxBuilder);
        } catch (SAXException | XMLStreamException | IOException e) {
            e.printStackTrace();
        }
        return candiesList;
    }
}
