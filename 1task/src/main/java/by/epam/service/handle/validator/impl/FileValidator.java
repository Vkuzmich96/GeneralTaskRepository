package by.epam.service.handle.validator.impl;

import by.epam.service.handle.validator.ValidationResult;
import by.epam.service.handle.validator.Validator;
import java.util.List;

public class FileValidator implements Validator {

    private int ARGUMENT_LENGTH;
    private DataTypesValidConditions typesValidConditions;

    public FileValidator(int ARGUMENT_LENGTH, DataTypesValidConditions typesValidConditions) {
        this.ARGUMENT_LENGTH = ARGUMENT_LENGTH;
        this.typesValidConditions = typesValidConditions;
    }

    @Override
    public ValidationResult valid(List<String[]> strings) {
        ValidationResult result = new ValidationResult();
        for (int i =0; i<strings.size(); ++i){
            if (!isArgumentLengthValid(strings.get(i),result,i)) continue;
            typesValidConditions.isDataTypesValid(strings.get(i),result,i);
        }
        return result;
    }

    private boolean isArgumentLengthValid(
            String[] string,
            ValidationResult result,
            int number
    ){
        if (string.length==ARGUMENT_LENGTH){
            result.setValid(true);
            return true;
        } else {
            result.setValid(false);
            result.addMassages("in string № " + number +  " problems with argument length");
            return false;
        }
    }
}
