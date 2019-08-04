package by.kuzmich.finaltask.command;

import by.kuzmich.finaltask.command.map.*;
import by.kuzmich.finaltask.command.user.*;
import by.kuzmich.finaltask.command.builder.BuilderFactory;
import by.kuzmich.finaltask.command.builder.BuilderKind;
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
                return new PostUserLogIn(
                        BuilderFactory.getInstance().get(BuilderKind.USER_ENTER),
                        UserServiceFactory.getInstance().get(),
                        LawMapNameServiceFactory.getInstance().get(),
                        CookieHandlerFactory.getInstance().get()
                );
            case MAP_GET:
                return new GetMap();
            case ACTION_GET:
                return new GetAction(
                        ActionServiceFactory.getInstance().get()
                );
            case LOG_OUT:
                return new UserLogOut(
                        CookieHandlerFactory.getInstance().get(),
                        SessionHandlerFactory.getInstance().get()
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
            case POST_MAP_NAME:
                return new PostMapName(
                        LawMapNameServiceFactory.getInstance().get(),
                        SessionHandlerFactory.getInstance().get()
                );
            case POST_ACTION:
                return new PostAction(
                        ActionServiceFactory.getInstance().get(),
                        BuilderFactory.getInstance().get(BuilderKind.ACTION_CHILD),
                        BuilderFactory.getInstance().get(BuilderKind.ACTION_PARENT),
                        SessionHandlerFactory.getInstance().get(),
                        MapServiceFactory.getInstance().get()
                );
            case GET_USER_PROFILE:
                return new GetUserProfile(
                        SessionHandlerFactory.getInstance().get(),
                        UserServiceFactory.getInstance().get()
                );
            case POST_UPDATE_USER_PROFILE:
                return new PostUpdateUserProfile(
                        UserServiceFactory.getInstance().get(),
                        SessionHandlerFactory.getInstance().get()
                );
            case CONTINUE:
                return new GetLawyerMenuContinue(
                        SessionHandlerFactory.getInstance().get(),
                        MapServiceFactory.getInstance().get()
                );
            default:
                return null;
        }
    }
}
