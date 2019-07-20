package by.kuzmich.finaltask.action;

import by.kuzmich.finaltask.action.map.MapGet;
import by.kuzmich.finaltask.action.user.UserAdd;
import by.kuzmich.finaltask.action.user.UserEnter;
import by.kuzmich.finaltask.controller.builder.BuilderFactory;
import by.kuzmich.finaltask.controller.builder.BuilderKind;
import by.kuzmich.finaltask.service.LawMapNameServiceFactory;
import by.kuzmich.finaltask.service.MapServiceFactory;
import by.kuzmich.finaltask.service.UserServiceFactory;

final public class CommandFactory {
    private final static CommandFactory factory = new CommandFactory();
    public static CommandFactory getInstance(){
        return factory;
    }

    private CommandFactory(){}

    public Command get(CommandKind command) {
        switch (command){
            case ADD_USER:
                return new UserAdd(
                        BuilderFactory.getInstance().get(BuilderKind.USER_REGISTRATION),
                        UserServiceFactory.getInstance().get()
                );
            case ENTER_USER:
                return new UserEnter(
                        BuilderFactory.getInstance().get(BuilderKind.USER_ENTER),
                        UserServiceFactory.getInstance().get(),
                        LawMapNameServiceFactory.getInstance().get()
                );
            case MapGet:
                return new MapGet(
                        MapServiceFactory.getInstance().get()
                );
            default:
                return null;
        }
    }
}
