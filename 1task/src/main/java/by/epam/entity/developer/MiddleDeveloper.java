package by.epam.entity.developer;

import by.epam.entity.Position;

public class MiddleDeveloper extends Developer {

    public MiddleDeveloper(String name, int experience, int Salary, String language, int id) {
        super(Salary, Position.MIDDLE, name, experience, language, id);
    }

    public MiddleDeveloper() {
        super(Position.MIDDLE);
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
        return  "MiddleDeveloper{ " + '\'' +
                super.toString() +
                " }"
                ;
    }
}
