package by.epam.service.handle.validator.impl;

import by.epam.service.handle.validator.ValidationResult;

public class DataTypesValidConditions {

    private final int KIND_EMPLOYEE = 0;
    private final int POSITION_ARGUMENT = 1;
    private final int LANGUAGE_ARGUMENT = 2;
    private final int NAME_ARGUMENT = 3;
    private final int EXPERIENCE_ARGUMENT = 4;
    private final int SALARY_ARGUMENT = 5;


    //todo Дорабоатать условия валидности с учётом производительности и null аргументов

    public void isDataTypesValid(
            String[] string,
            ValidationResult result,
            int number
    ){
        if(string[KIND_EMPLOYEE].getClass()!=(String.class)||
            string[POSITION_ARGUMENT].getClass()!=(String.class)||
            string[LANGUAGE_ARGUMENT].getClass()!=(String.class)||
            string[NAME_ARGUMENT].getClass()!=(String.class)
        ){
            result.setValid(false);
            result.addMassages("in string № " + number +  " problems with argument type");
        }
        try {
            Integer.parseInt(string[EXPERIENCE_ARGUMENT]);
            Integer.parseInt(string[SALARY_ARGUMENT]);
        }catch (NumberFormatException e){
            result.setValid(false);
            result.addMassages("in string № " + number +  " problems with argument type");
        }
    }
}
