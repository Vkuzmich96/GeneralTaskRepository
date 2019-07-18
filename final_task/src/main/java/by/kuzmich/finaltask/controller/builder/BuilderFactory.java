package by.kuzmich.finaltask.controller.builder;

import by.kuzmich.finaltask.controller.builder.impl.UserBuilderEnter;
import by.kuzmich.finaltask.controller.builder.impl.UserBuilderRegistration;

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
                return new UserBuilderRegistration();
            case USER_ENTER:
                return new UserBuilderEnter();
        }
    }
}
