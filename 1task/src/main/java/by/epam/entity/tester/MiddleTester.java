package by.epam.entity.tester;

import by.epam.entity.Position;

public class MiddleTester extends Tester {

    public MiddleTester(String name, int experience, int Salary, TestingKind testingKind, int id ) {
        super(Salary, Position.MIDDLE, name, experience, testingKind, id);
    }

    public MiddleTester() {
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
        return  "MiddleTester{ " + '\'' +
                super.toString() +
                " }"
                ;
    }
}
