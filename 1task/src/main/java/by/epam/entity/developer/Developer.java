package by.epam.entity.developer;


import by.epam.entity.Employee;
import by.epam.entity.Kind;
import by.epam.entity.Position;

public abstract class Developer extends Employee {
    private String language;
    public Developer(int salary, Position position, String name, int experience, String language, int id) {
        super(salary, position, name, experience, Kind.DEVELOPER, id);
        this.language = language;
    }

    public Developer(Position position) {
        super(Kind.DEVELOPER, position);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
        return  "language='" + language + '\''+
                super.toString();
    }
}
