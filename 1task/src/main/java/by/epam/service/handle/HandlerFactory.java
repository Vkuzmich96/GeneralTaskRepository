package by.epam.service.handle;

import by.epam.service.handle.creator.chain.CreatorFactory;
import by.epam.service.handle.creator.chain.CreatorKey;
import by.epam.service.handle.impl.FileHandleService;
import by.epam.service.handle.parser.ParserKey;
import by.epam.service.handle.parser.ParserSingletoneFactory;
import by.epam.service.handle.validator.ValidatorKey;
import by.epam.service.handle.validator.ValidatorSingletoneFactory;

import java.util.HashMap;
import java.util.Map;

public class HandlerFactory {
    private static final HandlerFactory factory = new HandlerFactory();
    private Map<HandlerKey, Handler> handlerMap = new HashMap<>();

    public static HandlerFactory getInstance() {
        return factory;
    }

    public Handler getHandler (HandlerKey key) {
        return handlerMap.get(key);
    }

    private HandlerFactory() {
        handlerMap.put(HandlerKey.FILE_HANDLER,
                new FileHandleService(
                        ParserSingletoneFactory.getInstance().getParser(ParserKey.FILE_PARSER),
                        ValidatorSingletoneFactory.getInstance().getValidator(ValidatorKey.FILE_VALIDATOR),
                        CreatorFactory.getInstance().getCreator(CreatorKey.EMPLOYEE_CREATOR)
                )
        );
    }

}
