package by.kuzmich.finaltask.command;

import by.kuzmich.finaltask.command.builder.BuilderFactory;
import by.kuzmich.finaltask.command.builder.BuilderKind;
import by.kuzmich.finaltask.command.map.*;
import by.kuzmich.finaltask.command.user.*;
import by.kuzmich.finaltask.controller.session.SessionHandlerFactory;
import by.kuzmich.finaltask.service.ActionServiceFactory;
import by.kuzmich.finaltask.service.LawMapNameServiceFactory;
import by.kuzmich.finaltask.service.MapServiceFactory;
import by.kuzmich.finaltask.service.UserServiceFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

final public class PostCommandFactory {
    private static Logger logger = Logger.getLogger(PostCommandFactory.class);
    private final static PostCommandFactory factory = new PostCommandFactory();
    private static final String CONFIG_PROPERTIES_NAME = "pathConfig.properties";
    private static final String CONFIG_PROPERTIES_KEY = "path.config.file.docs";
    public static PostCommandFactory getInstance(){
        return factory;
    }

    private PostCommandFactory(){}

    public Command get(CommandKind command) {
        switch (command){
            case ADD_USER:
                return new PostUserRegistration(
                        BuilderFactory.getInstance().get(BuilderKind.USER_REGISTRATION),
                        UserServiceFactory.getInstance().get(),
                        SessionHandlerFactory.getInstance().get()
                );
            case ENTER_USER:
                return new PostUserLogIn(
                        SessionHandlerFactory.getInstance().get(),
                        UserServiceFactory.getInstance().get()
                );
            case POST_MAP_NAME:
                return new PostMapName(
                        LawMapNameServiceFactory.getInstance().get()
                );
            case POST_ACTION:
                Properties configProperties = new Properties();
                try {
                    configProperties.load(PostAction.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES_NAME));
                    return new PostAction(
                            ActionServiceFactory.getInstance().get(),
                            BuilderFactory.getInstance().get(BuilderKind.ACTION_CHILD),
                            BuilderFactory.getInstance().get(BuilderKind.ACTION_PARENT),
                            MapServiceFactory.getInstance().get(),
                            configProperties.getProperty(CONFIG_PROPERTIES_KEY)
                    );
                } catch (IOException e) {
                    logger.error(e);
                }
            case POST_UPDATE_USER_PROFILE:
                return new PostUpdateUserProfile(
                        UserServiceFactory.getInstance().get(),
                        SessionHandlerFactory.getInstance().get()
                );
            case POST_UPDATE_ACTION:
                return new PostUpdateAction(
                        ActionServiceFactory.getInstance().get()
                );
            default:
                return null;
        }
    }
}
