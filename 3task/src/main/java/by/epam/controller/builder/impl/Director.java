package by.epam.controller.builder.impl;

import by.epam.bean.Candy;
import by.epam.controller.builder.Builder;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public class Director {
    public static List<Candy> build (String url, Builder builder) throws SAXException, IOException, XMLStreamException {
        return builder.build(url);
    }
}
