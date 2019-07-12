package by.epam.service.handle.validator.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class FileValidatorTest {

private int ARGUMENT_LENGTH = 6;

private FileValidator validator = new FileValidator(ARGUMENT_LENGTH, new DataTypesValidConditions());

private List<String[]> list = new ArrayList<>();

    @Test
    public void valid() {
        list.clear();
        list.add("junior;developer;java;Vasya;1;350".split(";"));
        list.add("junior;developer;java;Vasya;1;300".split(";"));
        Assert.assertTrue(validator.valid(list).isValid());
    }

    @Test
    public void invalid(){
        list.clear();
        list.add("juniordeveloperVasya1;350".split(";"));
        list.add("junior;junior;junior;junior;junior;junior".split(";"));
        Assert.assertFalse(validator.valid(list).isValid());
    }

    @Test
    public void massage(){
        list.clear();
        list.add("juniordeveloperVasya1;350".split(";"));
        list.add("junior;junior;junior;junior;junior;junior".split(";"));
        int actual = validator.valid(list).getMassages().size();
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }
}