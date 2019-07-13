package by.epam.controller.builder.impl;

import by.epam.bean.Candy;
import by.epam.controller.builder.TagHandler;
import by.epam.controller.builder.Builder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SaxBuilder implements Builder {
    private TagHandler generalHandler;
    private SAXParser parser;
    private SAXHandler handler = new SAXHandler();


    public SaxBuilder(TagHandler generalHandler, SAXParser parser){
        this.generalHandler = generalHandler;
        this.parser = parser;
    }

    @Override
    public List<Candy> build(String url) throws IOException, SAXException {
        parser.parse( url, handler );
        return handler.candyList;
    }

    class SAXHandler extends DefaultHandler {
        private List<Candy> candyList = new ArrayList<>();
        private Candy candy;
        private String content;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if("candi".equals(qName)) {
                candy = new Candy();
                candy.setId(attributes.getValue("id"));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if ("candi".equals(qName)) candyList.add(candy);
            generalHandler.handle(candy, qName, content);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            content = String.copyValueOf(ch, start, length).trim();
        }
    }
}
