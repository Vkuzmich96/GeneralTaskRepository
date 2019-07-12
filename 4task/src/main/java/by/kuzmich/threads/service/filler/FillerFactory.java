package by.kuzmich.threads.service.filler;

import by.kuzmich.threads.service.filler.impl.MultyThreadFillerService;

import java.util.HashMap;
import java.util.Map;
import by.kuzmich.threads.bean.Matrix;

public class FillerFactory {
    private static FillerFactory factory = new FillerFactory();
    private Map<FillerKey, Filler> map = new HashMap<>();

    public static FillerFactory getInstance(){
        return factory;
    }

    public FillerFactory() {
        map.put(FillerKey.ThreadFiller, new MultyThreadFillerService(new Matrix()));
    }

    public Filler get(FillerKey key){
        return map.get(key);
    }
}
