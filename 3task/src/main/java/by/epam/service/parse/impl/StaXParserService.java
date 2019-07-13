package by.epam.service.parse.impl;

import by.epam.bean.Candy;
import by.epam.controller.builder.BuilderFactory;
import by.epam.controller.builder.BuilderKey;
import by.epam.controller.builder.impl.Director;
import by.epam.controller.builder.impl.StaxBuilder;
import by.epam.service.parse.Parser;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public class StaXParserService implements Parser {
    private StaxBuilder staxBuilder = (StaxBuilder) BuilderFactory.getInstance().getBuilder(BuilderKey.STAX);

    @Override
    public List<Candy> parse(String url) {
        List<Candy> candiesList = null;
        try {
            candiesList = Director.build("candy.xml", staxBuilder);
        } catch (SAXException | XMLStreamException | IOException e) {
            e.printStackTrace();
        }
        return candiesList;
    }
}
