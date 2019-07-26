package by.kuzmich.finaltask.command;

import by.kuzmich.finaltask.command.map.GetAction;
import by.kuzmich.finaltask.command.map.PostMaterial;
import by.kuzmich.finaltask.command.map.GetAllMpaNames;
import by.kuzmich.finaltask.command.map.GetMap;
import by.kuzmich.finaltask.command.user.*;
import by.kuzmich.finaltask.controller.builder.BuilderFactory;
import by.kuzmich.finaltask.controller.builder.BuilderKind;
import by.kuzmich.finaltask.controller.cookie.CookieHandlerFactory;
import by.kuzmich.finaltask.controller.session.SessionHandlerFactory;
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
                return new PostUserRegistration(
                        BuilderFactory.getInstance().get(BuilderKind.USER_REGISTRATION),
                        UserServiceFactory.getInstance().get(),
                        CookieHandlerFactory.getInstance().get()
                );
            case ENTER_USER:
                return new PostUserEnter(
                        BuilderFactory.getInstance().get(BuilderKind.USER_ENTER),
                        UserServiceFactory.getInstance().get(),
                        LawMapNameServiceFactory.getInstance().get(),
                        CookieHandlerFactory.getInstance().get()
                );
            case MAP_GET:
                return new GetMap(
                        MapServiceFactory.getInstance().get()
                );
            case ACTION_GET:
                return new GetAction(
                        ActionServiceFactory.getInstance().get()
                );
            case LOG_OUT:
                return new UserLogOut(
                        CookieHandlerFactory.getInstance().get()
                );
            case CREATE_SESSION:
                return new CreateSession(
                        UserServiceFactory.getInstance().get(),
                        SessionHandlerFactory.getInstance().get(),
                        CookieHandlerFactory.getInstance().get()
                );
            case GET_LAWER_MENU:
                return new GetLawerMenu();
            case ADD_MATERIAL:
                return new PostMaterial();
            case GET_ALL_MAP_NAMES:
                return new GetAllMpaNames(
                        LawMapNameServiceFactory.getInstance().get()
                );
            default:
                return null;
        }
    }
}
