package by.epam.service.handle.parser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ParserSingletoneFactoryTest {
    private ParserSingletoneFactory parserFactory = ParserSingletoneFactory.getInstance();

    @Test
    public void getInstance() {
        Assert.assertNotNull(parserFactory);
    }

    @Test
    public void getParser(){
        Parser fileParser = parserFactory.getParser(ParserKey.FILE_PARSER);
        Assert.assertNotNull(fileParser);
    }
}