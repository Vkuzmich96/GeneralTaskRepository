package by.epam.controller.builder;

import by.epam.bean.Candy;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public interface Builder {
    List<Candy> build(String url) throws IOException, SAXException, XMLStreamException;
}
