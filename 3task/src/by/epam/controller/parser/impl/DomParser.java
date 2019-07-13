package by.epam.controller.parser.impl;

import by.epam.bean.Candy;
import by.epam.bean.Ingredients;
import by.epam.bean.Values;
import by.epam.controller.parser.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder builder = factory.newDocumentBuilder();
    private Document document = builder.parse("candy.xml");
    private List<Candy> list = new ArrayList<>();

    public DomParser() throws ParserConfigurationException, IOException, SAXException {
    }

    public List<Candy> parse() {
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Candy candy = new Candy();
                candy.setId(node.getAttributes().getNamedItem("id").getNodeValue());
                handle(node, candy);
                list.add(candy);
            }
        }
        return list;
    }

    private void handle(Node node, Candy candy){
        NodeList childNodes = node.getChildNodes();
        for (int j = 0; j < childNodes.getLength(); j++) {
            selectHandler(childNodes.item(j), candy);
        }
    }

    private void selectHandler(Node node, Candy candy) {
        if (node instanceof Element) {
            String content = node.getLastChild().getTextContent().trim();
            switch (node.getNodeName()) {
                case "name":
                    candy.setName(content);
                    break;
                case "energy":
                    candy.setEnergy(content);
                    break;
                case "type":
                    candy.setType(content);
                    break;
                case "ingredients":
                    handle(node,candy);
                    break;
                case "value":
                    handle(node,candy);
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
    }
}
