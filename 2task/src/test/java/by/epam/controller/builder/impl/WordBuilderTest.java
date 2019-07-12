package by.epam.controller.builder.impl;

import by.epam.controller.ControllerException;
import by.epam.service.composit.Ellyment;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WordBuilderTest {

    private final WordBuilder builder = new WordBuilder();
    private final String sentence = "It is a established fact that a reader will be of a page when looking at its layout";

    @Test
    public void build() {
        List<Ellyment> list = builder.build(sentence);
        assertEquals(18,list.size());
    }

    @Test(expected = ControllerException.class)
    public void linkWith() throws ControllerException {
        builder.linkWith(builder);
    }
}