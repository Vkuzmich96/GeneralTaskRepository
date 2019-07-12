package by.epam.controller.builder;

import by.epam.bean.PartOfTextKind;
import by.epam.controller.ControllerException;
import by.epam.controller.builder.impl.BuilderChainContainer;
import by.epam.controller.builder.impl.TextBuilder;
import by.epam.controller.builder.impl.WordBuilder;
import by.epam.service.composit.Ellyment;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class BuilderChainFactory {
    final static Logger logger = Logger.getLogger(BuilderChainFactory.class);

    private final static BuilderChainFactory factory = new BuilderChainFactory();

    private final Map<BuilderKey, Builder<Ellyment>> map = new HashMap<>();

    public static BuilderChainFactory getInstance() {
        return factory;
    }

    public Builder<Ellyment> get(BuilderKey key){
        return map.get(key);
    }

    private BuilderChainFactory()  {
        TextBuilder builder = new TextBuilder();
        try {
            builder.linkWith(new BuilderChainContainer(Delimiters.PARAGRAPH, PartOfTextKind.PARAGRAPH))
                   .linkWith(new BuilderChainContainer(Delimiters.SENTENCE, PartOfTextKind.SENTENCE))
                   .linkWith(new WordBuilder());
        } catch (ControllerException e) {
            logger.error(e.getMessage());
        }

        map.put(BuilderKey.TEXT_PARSER, builder);

    }

}
