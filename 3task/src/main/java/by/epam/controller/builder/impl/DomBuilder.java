package by.epam.controller.builder.impl;

import by.epam.bean.Candy;
import by.epam.controller.builder.TagHandler;
import by.epam.controller.builder.Builder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomBuilder implements Builder {
    private DocumentBuilder builder;
    private List<Candy> list = new ArrayList<>();
    private TagHandler handler;


    public DomBuilder(TagHandler handler, DocumentBuilder builder ) {
         this.handler = handler;
         this.builder = builder;
    }

    public List<Candy> build(String url) throws IOException, SAXException {
        Document document = builder.parse( url );

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
            String tag = node.getNodeName();
            handler.handle(candy, tag, content);
            if ("ingredients".equals(tag) || "value".equals(tag) || "type".equals(tag)){
                handle(node, candy);
            }
            if ("filled".equals(tag)){
                candy.setFilled(Boolean.parseBoolean(content));
            }
        }
    }
}
