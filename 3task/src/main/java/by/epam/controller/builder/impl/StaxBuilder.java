package by.epam.controller.builder.impl;

import by.epam.bean.Candy;
import by.epam.controller.builder.TagHandler;
import by.epam.controller.builder.Builder;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StaxBuilder implements Builder {
    private XMLInputFactory factory;
    private TagHandler handler;

    public StaxBuilder(XMLInputFactory factory, TagHandler handler) {
        this.factory = factory;
        this.handler = handler;
    }

    @Override
    public List<Candy> build(String url) throws XMLStreamException {
        List<Candy> candyList = null;
        Candy candy = null;
        String content = null;
        XMLStreamReader reader = factory.createXMLStreamReader( ClassLoader.getSystemResourceAsStream ( url ) );
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("candi".equals(reader.getLocalName())) {
                        candy = new Candy();
                        candy.setId(reader.getAttributeValue(0));
                    }
                    if ("candies".equals(reader.getLocalName())) candyList = new ArrayList<>();
                    break;
                case XMLStreamConstants.CHARACTERS:
                    content = reader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    String tag = reader.getLocalName();
                    if("candi".equals(tag)) candyList.add(candy);
                    handler.handle(candy, tag, content);
                    break;
                case XMLStreamConstants.START_DOCUMENT:
                    candyList = new ArrayList<>();
                    break;
            }
        }
        return candyList;
    }
}
