package by.epam.entity;


import java.util.Objects;

public abstract class Employee {
    private int id;
    private String name;
    private int experience;
    private int salary;
    private Position position;
    private Kind kind;

    public Employee(int salary, Position position, String name, int  experience, Kind kind, int id) {
        this.salary = salary;
        this.position = position;
        this.name = name;
        this.experience = experience;
        this.id = id;
        this.kind =kind;
    }

    public Employee(Kind kind, Position position) {
        this.kind = kind;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, experience, salary, position, kind);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", salary=" + salary +
                ", position=" + position +
                ", kind=" + kind;
    }
}
