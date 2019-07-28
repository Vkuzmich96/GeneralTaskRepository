package by.kuzmich.finaltask.command.builder;

import by.kuzmich.finaltask.command.builder.impl.ActionChildBuilder;
import by.kuzmich.finaltask.command.builder.impl.ActionParentBuilder;
import by.kuzmich.finaltask.command.builder.impl.UserEnterBuilder;
import by.kuzmich.finaltask.command.builder.impl.UserRegistrationBuilder;
import by.kuzmich.finaltask.controller.cookie.CookieHandlerFactory;
import by.kuzmich.finaltask.service.UserServiceFactory;

final public class BuilderFactory {
    private static BuilderFactory factory = new BuilderFactory();
    private BuilderFactory(){}
    public static BuilderFactory getInstance(){
        return factory;
    }

    public Builder get(BuilderKind kind){
        switch (kind){
            default:
                return null;
            case USER_REGISTRATION:
                return new UserRegistrationBuilder();
            case USER_ENTER:
                return new UserEnterBuilder();
            case ACTION_CHILD:
                return new ActionChildBuilder(
                        UserServiceFactory.getInstance().get(),
                        CookieHandlerFactory.getInstance().get()
                );
            case ACTION_PARENT:
                return new ActionParentBuilder();
        }
    }
}
