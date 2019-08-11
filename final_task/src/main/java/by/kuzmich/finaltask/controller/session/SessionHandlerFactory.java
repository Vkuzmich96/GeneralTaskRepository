package by.kuzmich.finaltask.controller.session;

public class SessionHandlerFactory {
    private static SessionHandlerFactory factory = new SessionHandlerFactory();
    private SessionHandlerFactory(){}
    public static SessionHandlerFactory getInstance(){
        return factory;
    }

    public SessionHandler get() {
        return new SessionHandlerUser();
    }
}
