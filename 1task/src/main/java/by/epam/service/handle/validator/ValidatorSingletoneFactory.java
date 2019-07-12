package by.epam.service.handle.validator;

import by.epam.service.handle.validator.impl.DataTypesValidConditions;
import by.epam.service.handle.validator.impl.FileValidator;
import java.util.HashMap;
import java.util.Map;

public class ValidatorSingletoneFactory {
    private final int ACTUAL_ARGUMENT_LENGTH = 6;

    private Map<ValidatorKey, Validator> parserMap;

    public static ValidatorSingletoneFactory getInstance(){
        return ValidatorSingletoneFactory.SingletoneHolder.factory;
    }

    public Validator getValidator(ValidatorKey validatorKey) {
        return parserMap.get(validatorKey);
    }

    private ValidatorSingletoneFactory(){
        parserMap = new HashMap<>();
        parserMap.put(ValidatorKey.FILE_VALIDATOR, new FileValidator(ACTUAL_ARGUMENT_LENGTH, new DataTypesValidConditions()));
    }

    private static class SingletoneHolder {
        private static ValidatorSingletoneFactory factory;
        static {
            factory = new ValidatorSingletoneFactory();
        }
    }
}
