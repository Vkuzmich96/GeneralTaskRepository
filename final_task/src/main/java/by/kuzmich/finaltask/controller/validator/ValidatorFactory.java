package by.kuzmich.finaltask.controller.validator;

import by.kuzmich.finaltask.command.CommandKind;
import by.kuzmich.finaltask.controller.validator.impl.EnterUserValidator;
import by.kuzmich.finaltask.controller.validator.impl.RegistrationFormValidator;

import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {
    private static ValidatorFactory factory = new ValidatorFactory();
    public static ValidatorFactory getInstance(){
        return factory;
    }

    private Map<CommandKind, Validator> map = new HashMap<>();
    private ValidatorFactory() {
        map.put(CommandKind.ADD_USER, new RegistrationFormValidator());
        map.put(CommandKind.ENTER_USER, new EnterUserValidator());
    }

    public Validator get (CommandKind key) {
        return map.get(key);
    }
}
