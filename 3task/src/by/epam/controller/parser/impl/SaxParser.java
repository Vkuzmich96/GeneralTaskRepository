package by.epam.controller.parser.impl;

import by.epam.bean.Candy;
import by.epam.bean.Ingredients;
import by.epam.bean.Values;
import by.epam.controller.parser.Parser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements Parser {
    private SAXParserFactory parserFactor = SAXParserFactory.newInstance();
    private SAXParser parser = parserFactor.newSAXParser();
    private SAXHandler handler = new SAXHandler();

    public SaxParser() throws ParserConfigurationException, SAXException {
    }

    @Override
    public List<Candy> parse() throws IOException, SAXException {
        parser.parse("candy.xml", handler);
        return handler.candyList;
    }

    class SAXHandler extends DefaultHandler {
        List<Candy> candyList = new ArrayList<>();
        private Candy candy;
        private String content;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            switch (qName) {
                case "candi":
                    candy = new Candy();
                    candy.setId(attributes.getValue("id"));
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            switch (qName) {
                case "candi":
                    candyList.add(candy);
                    break;
                case "name":
                    candy.setName(content);
                    break;
                case "energy":
                    candy.setEnergy(content);
                    break;
                case "type":
                    candy.setType(content);
                    break;
                case "woter":
                    candy.addIngredient(Ingredients.Woter,content);
                    break;
                case "sugar":
                    candy.addIngredient(Ingredients.Sugar,content);
                    break;
                case "protein":
                    candy.addValues(Values.Protein,content);
                    break;
                case "fat":
                    candy.addValues(Values.Fat,content);
                    break;
                case "carbohydrates":
                    candy.addValues(Values.Carbohydrates,content);
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            content = String.copyValueOf(ch, start, length).trim();
        }
    }
}
