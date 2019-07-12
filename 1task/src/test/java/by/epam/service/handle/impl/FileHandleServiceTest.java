package by.epam.service.handle.impl;

import by.epam.service.ServiceException;
import by.epam.service.handle.Handler;
import by.epam.service.handle.HandlerFactory;
import by.epam.service.handle.HandlerKey;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileHandleServiceTest {
    private Handler handler = HandlerFactory.getInstance().getHandler(HandlerKey.FILE_HANDLER);

    @Test
    public void handle() throws ServiceException {
        int actual = handler.handle("TestValues.txt").size();
        int expected = 11;
        assertEquals(expected,actual);
    }
}