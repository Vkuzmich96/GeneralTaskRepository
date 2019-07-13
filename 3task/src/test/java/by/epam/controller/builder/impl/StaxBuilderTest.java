package by.epam.controller.builder.impl;

import by.epam.bean.Candy;
import by.epam.controller.builder.BuilderFactory;
import by.epam.controller.builder.BuilderKey;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class StaxBuilderTest {
    private StaxBuilder staxBuilder = (StaxBuilder) BuilderFactory.getInstance().getBuilder(BuilderKey.STAX);

    @Test
    public void build() throws SAXException, IOException, XMLStreamException {
        List<Candy> candies = Director.build("candy.xml",staxBuilder);
        assertEquals(3, candies.size());
    }
}