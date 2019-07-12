package by.epam.controller.builder;

import by.epam.controller.ControllerException;
import by.epam.controller.parser.Parser;
import by.epam.controller.parser.ParserFactory;
import by.epam.controller.parser.ParserKey;
import by.epam.service.composit.Ellyment;
import org.junit.Test;

import javax.sound.midi.Patch;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class BuilderTest {
    private final Parser parser = ParserFactory.getInstance().get(ParserKey.ELLYMENT_PARSER);
    private final Builder<Ellyment> builder = BuilderChainFactory.getInstance().get(BuilderKey.TEXT_PARSER);
    private final Path path = Paths.get("lorenIpsum");

    @Test
    public void build() throws ControllerException {
        String text = parser.parse(path);
        Ellyment ellyment = builder.build(text);
        assertNotNull(ellyment);
    }
}