package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.service.MapService;
import by.kuzmich.finaltask.service.MapServiceFactory;
import org.junit.Test;

public class MapServiceImplTest {
    private MapService service = MapServiceFactory.getInstance().get();

    @Test
    public void get() {
        service.get("1");
    }
}