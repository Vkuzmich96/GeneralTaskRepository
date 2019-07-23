package by.kuzmich.finaltask.command;

import by.kuzmich.finaltask.command.map.ActionGet;
import by.kuzmich.finaltask.command.map.MapGet;
import by.kuzmich.finaltask.command.user.UserAdd;
import by.kuzmich.finaltask.command.user.UserEnter;
import by.kuzmich.finaltask.controller.builder.BuilderFactory;
import by.kuzmich.finaltask.controller.builder.BuilderKind;
import by.kuzmich.finaltask.controller.cookie.CookieHandlerFactory;
import by.kuzmich.finaltask.controller.cookie.CookieHandlerUserAccess;
import by.kuzmich.finaltask.service.ActionServiceFactory;
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
                        UserServiceFactory.getInstance().get(),
                        CookieHandlerFactory.getInstance().get()
                );
            case ENTER_USER:
                return new UserEnter(
                        BuilderFactory.getInstance().get(BuilderKind.USER_ENTER),
                        UserServiceFactory.getInstance().get(),
                        LawMapNameServiceFactory.getInstance().get(),
                        CookieHandlerFactory.getInstance().get()
                );
            case MAP_GET:
                return new MapGet(
                        MapServiceFactory.getInstance().get()
                );
            case ACTION_GET:
                return new ActionGet(
                        ActionServiceFactory.getInstance().get()
                );
            default:
                return null;
        }
    }
}
