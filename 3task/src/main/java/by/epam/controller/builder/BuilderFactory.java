package by.epam.controller.builder;

import by.epam.controller.builder.impl.DomBuilder;
import by.epam.controller.builder.impl.GeneralTagHandleOperations;
import by.epam.controller.builder.impl.SaxBuilder;
import by.epam.controller.builder.impl.StaxBuilder;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import java.util.HashMap;
import java.util.Map;

public class BuilderFactory {
    private static BuilderFactory factory = new BuilderFactory();
    private Map<BuilderKey, Builder> map = new HashMap<>();
    private BuilderFactory(){
        try {
            map.put(BuilderKey.DOM, new DomBuilder(
                    new GeneralTagHandleOperations(),
                    DocumentBuilderFactory.newInstance()
                                          .newDocumentBuilder()
            ));
            map.put(BuilderKey.SAX, new SaxBuilder(
                    new GeneralTagHandleOperations(),
                    SAXParserFactory.newInstance()
                                    .newSAXParser()
            ));
            map.put(BuilderKey.STAX, new StaxBuilder(
                    XMLInputFactory.newInstance(),
                    new GeneralTagHandleOperations()
            ));
        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("ups");
        }
    }

    public static BuilderFactory getInstance(){
        return factory;
    }

    public Builder getBuilder(BuilderKey key){
        return map.get(key);
    }

}
