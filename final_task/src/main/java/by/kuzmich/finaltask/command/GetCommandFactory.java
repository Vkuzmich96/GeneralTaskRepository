package by.kuzmich.finaltask.command;

import by.kuzmich.finaltask.command.map.*;
import by.kuzmich.finaltask.command.user.*;
import by.kuzmich.finaltask.controller.cookie.CookieHandlerFactory;
import by.kuzmich.finaltask.controller.session.SessionHandlerFactory;
import by.kuzmich.finaltask.service.ActionServiceFactory;
import by.kuzmich.finaltask.service.LawMapNameServiceFactory;
import by.kuzmich.finaltask.service.MapServiceFactory;
import by.kuzmich.finaltask.service.UserServiceFactory;

final public class GetCommandFactory {
    private final static GetCommandFactory factory = new GetCommandFactory();
    public static GetCommandFactory getInstance(){
        return factory;
    }

    private GetCommandFactory(){}

    public Command get(CommandKind command) {
        switch (command){
            case MAP_GET:
                return new GetMap();
            case ACTION_GET:
                return new GetAction(
                        ActionServiceFactory.getInstance().get()
                );
            case GET_LAWER_MENU:
                return new GetLawerMenu();
            case GET_ALL_MAP_NAMES:
                return new GetAllMpaNames(
                        LawMapNameServiceFactory.getInstance().get()
                );
            case GET_USER_PROFILE:
                return new GetUserProfile(
                        SessionHandlerFactory.getInstance().get(),
                        UserServiceFactory.getInstance().get()
                );
            case CONTINUE:
                return new GetLawyerMenuContinue(
                        MapServiceFactory.getInstance().get()
                );
            case DELETE:
                return new PostDeleteMap(
                        LawMapNameServiceFactory.getInstance().get()
                );
            case REALISE:
                return new PostRealise(
                        LawMapNameServiceFactory.getInstance().get()
                );
            case GET_UPDATE_ACTION:
                return new GetUpdateAction(
                        ActionServiceFactory.getInstance().get()
                );
            case LOG_OUT:
                return new UserLogOut(
                        SessionHandlerFactory.getInstance().get()
                );
            case GET_SET_LOCALE:
                return new GetSetLocale(
                        CookieHandlerFactory.getInstance().get()
                );
            default:
                return null;
        }
    }
}
