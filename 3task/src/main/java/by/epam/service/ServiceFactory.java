package by.epam.service;

import by.epam.service.parse.impl.DOMParseService;
import by.epam.service.parse.impl.SAXParserService;

public class ServiceFactory {
    private static Service service = new Service(
            new DOMParseService(),
            new SAXParserService(),
            new SAXParserService()
    );
    public static Service getService(){
        return service;
    }
    private ServiceFactory(){}
}
