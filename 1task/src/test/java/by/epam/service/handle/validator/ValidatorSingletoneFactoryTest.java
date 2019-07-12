package by.epam.service.handle.validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ValidatorSingletoneFactoryTest {
    private ValidatorSingletoneFactory factory = ValidatorSingletoneFactory.getInstance();
    @Test
    public void getInstance() {
        Assert.assertNotNull(factory);
    }

    @Test
    public void getValidator() {
        Validator validator = factory.getValidator(ValidatorKey.FILE_VALIDATOR);
        Assert.assertNotNull(validator);
    }
}