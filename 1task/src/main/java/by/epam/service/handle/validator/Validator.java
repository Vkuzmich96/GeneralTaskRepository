package by.epam.service.handle.validator;

import java.util.List;

public interface Validator {
    ValidationResult valid(List<String[]> strings);
}
