package by.epam.service.handle.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidationResult {
    private boolean isValid = true;
    private List<String> massages = new ArrayList<>();

    public ValidationResult() {
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public List<String> getMassages() {
        return massages;
    }

    public void addMassages(String massage) {
        massages.add(massage) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidationResult that = (ValidationResult) o;
        return isValid == that.isValid &&
                Objects.equals(massages, that.massages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isValid, massages);
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "isValid=" + isValid +
                ", massages=" + massages +
                '}';
    }
}
