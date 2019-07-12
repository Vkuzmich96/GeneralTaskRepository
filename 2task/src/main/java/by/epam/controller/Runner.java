package by.epam.controller;


import org.apache.log4j.Logger;

public class Runner {
    final static Logger logger = Logger.getLogger(Runner.class);

    public static void main(String[] args) {

        Controller controller = ControllerFactory.getInstance().get(ControllerKey.ELLYMENT_CONTROLLER);
        try {
            controller.read("lorenIpsum");
        } catch (ControllerException e){
            logger.error(e.getMessage());
        }
        System.out.println(controller.show());
        controller.sort();
        System.out.println(controller.show());
    }
}
