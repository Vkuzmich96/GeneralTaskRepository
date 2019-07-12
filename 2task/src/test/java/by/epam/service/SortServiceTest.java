package by.epam.service;

import by.epam.controller.ControllerException;
import by.epam.controller.builder.Builder;
import by.epam.controller.builder.BuilderChainFactory;
import by.epam.controller.builder.BuilderKey;
import by.epam.controller.builder.Delimiters;
import by.epam.controller.parser.Parser;
import by.epam.controller.parser.ParserFactory;
import by.epam.controller.parser.ParserKey;
import by.epam.service.composit.Ellyment;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class SortServiceTest {
    private final Parser parser = ParserFactory.getInstance().get(ParserKey.ELLYMENT_PARSER);
    private final Builder<Ellyment> builder = BuilderChainFactory.getInstance().get(BuilderKey.TEXT_PARSER);
    private final Path path = Paths.get("lorenIpsum");
    private final SortService service = SortServiceFactory.getInstance().get(SortServiceKey.SORT_ELLYMENT_SERVICE_KEY);

    @Test
    public void sort() throws ControllerException {
        String text = parser.parse(path);
        Ellyment ellyment = builder.build(text);
        service.sort(ellyment);
        String string = ellyment.get();
        String[] strings = Delimiters.SENTENCE.split(string);
        assertEquals("Bye",strings[0]);
    }
}