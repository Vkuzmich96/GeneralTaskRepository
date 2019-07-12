package by.epam.entity.developer;

import by.epam.entity.Position;

public class JuniorDeveloper extends Developer {

    public JuniorDeveloper(String name, int experience, int Salary, String language, int id) {
        super(Salary, Position.JUNIOR, name, experience, language, id);
    }

    public JuniorDeveloper() {
        super(Position.JUNIOR);
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
        return  "JuniorDeveloper{ " + '\'' +
                super.toString() +
                " }"
                ;
    }
}
