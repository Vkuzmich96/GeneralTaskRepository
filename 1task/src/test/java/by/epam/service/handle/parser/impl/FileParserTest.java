package by.epam.service.handle.parser.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import by.epam.service.ServiceException;

@RunWith(JUnit4.class)
public class FileParserTest {
    private FileParser parser = new FileParser();

    @Test
    public void parse() {
        String path = "TestValues.txt";
        int actual = 0;
        try {
            actual = parser.parse(path).size();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        int expected = 11;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void split() {
        String path = "TestValues.txt";
        int actual = 0;
        try {
            actual = parser.parse(path).get(0).length;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        int expected = 6;
        Assert.assertEquals(actual,expected);
    }
}