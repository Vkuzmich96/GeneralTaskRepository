package by.epam.entity.developer;

import by.epam.entity.Position;

public class SeniorDeveloper extends Developer {
    public SeniorDeveloper(String name, int experience, int Salary, String language, int id) {
        super(Salary, Position.SENIOR, name, experience, language, id);
    }

    public SeniorDeveloper() {
        super(Position.SENIOR);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return  "SeniorDeveloper{ " + '\'' +
                super.toString() +
                " }"
                ;
    }
}
