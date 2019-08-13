package by.kuzmich.finaltask.controller.validator;

import by.kuzmich.finaltask.command.CommandKind;
import by.kuzmich.finaltask.command.builder.BuilderFactory;
import by.kuzmich.finaltask.command.builder.BuilderKind;
import by.kuzmich.finaltask.controller.validator.impl.EnterUserValidator;
import by.kuzmich.finaltask.controller.validator.impl.MapNameValidator;
import by.kuzmich.finaltask.controller.validator.impl.RegistrationFormValidator;
import by.kuzmich.finaltask.controller.validator.impl.UpdateUserValidator;
import by.kuzmich.finaltask.service.LawMapNameServiceFactory;
import by.kuzmich.finaltask.service.UserServiceFactory;

public class ValidatorFactory {
    private static ValidatorFactory factory = new ValidatorFactory();
    public static ValidatorFactory getInstance(){
        return factory;
    }
    private ValidatorFactory() {}

    public RequestValidator get (CommandKind key) {
        switch (key){
            case ADD_USER:
                return new RegistrationFormValidator(
                        UserServiceFactory.getInstance().get()
                );
            case ENTER_USER:
                return new EnterUserValidator(
                    BuilderFactory.getInstance().get(BuilderKind.USER_ENTER),
                    UserServiceFactory.getInstance().get()
                );
            case POST_UPDATE_USER_PROFILE:
                return new UpdateUserValidator();
            case POST_MAP_NAME:
                return new MapNameValidator(
                     LawMapNameServiceFactory.getInstance().get()
                );
            default:
                return null;
        }
    }
}
