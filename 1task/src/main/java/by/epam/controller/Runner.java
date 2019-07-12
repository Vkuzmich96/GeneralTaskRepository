package by.epam.controller;

import by.epam.service.Service;
import by.epam.service.ServiceException;
import by.epam.service.ServiceFactory;
import by.epam.service.ServiceKey;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Runner {

    private static String MENU = "press 1 for find employee\npres 2 for sort by salary\npres 3 for sort by experience\npress 4 for create team\npress 0 for exit team";
    private static Service service = ServiceFactory.getInstance().getGeneralService(ServiceKey.GENERAL);
    private static Scanner scanner = new Scanner(System.in);
    final static Logger logger = Logger.getLogger(Runner.class);

    public static void main(String[] args) {
        try {
            service.handle("file.txt");
        } catch (ServiceException e) {
            System.out.println("File reading failed");
            logger.error(e);
        }
        start();
    }

    private static void showMenu(){
        System.out.println(MENU);
    }

    private static void start(){
        boolean flag = true;
        while (flag){
            showMenu();
            flag = action(scanner.nextLine());
        }
    }

    private static boolean action(String chose){
        switch (chose){
            case "1":
                try {
                    System.out.println(service.find(scanner.nextLine(), scanner.nextLine()));
                } catch (ServiceException e) {
                    System.out.println("Entered wrong find parameters");
                    logger.error(e);
                }
                return true;
            case "2":
                System.out.println(service.sort("salary"));
                return true;
            case "3":
                System.out.println(service.sort("experience"));
                return true;
            case "4":
                System.out.println(service.create());
                return true;
            default:
                return false;
        }
    }
}
