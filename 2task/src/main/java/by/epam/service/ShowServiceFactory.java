package by.epam.service;

import java.util.HashMap;
import java.util.Map;

public class ShowServiceFactory {
    private static ShowServiceFactory factory = new ShowServiceFactory();

    public static ShowServiceFactory getInstance(){
        return factory;
    }

    private Map<ShowServiceKey, EllymentShowService> map = new HashMap<>();

    public EllymentShowService get (ShowServiceKey key){
        return map.get(key);
    }

    private ShowServiceFactory(){
        map.put(ShowServiceKey.SHOW_ELLYMENT_SERVICE_KEY, new EllymentShowService());
    }
}
