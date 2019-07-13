package by.epam.controller;

import by.epam.bean.Candy;
import by.epam.controller.parser.impl.DomParser;
import by.epam.controller.parser.impl.SaxParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException, SAXException {
        DomParser domParser = null;
        SaxParser saxParser = null;
        try {
            domParser = new DomParser();
            saxParser = new SaxParser();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
          List<Candy> candiesDom = domParser.parse();
          List<Candy> candiesSax = saxParser.parse();

        System.out.println(candiesDom);
        System.out.println(candiesSax);
    }
}
