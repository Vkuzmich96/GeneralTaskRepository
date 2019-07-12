package by.epam.entity.tester;

import by.epam.entity.Position;

public class JuniorTester extends Tester {

    public JuniorTester(String name, int experience, int salary, TestingKind testingKind, int id) {
        super(salary, Position.JUNIOR, name, experience, testingKind, id);
    }

    public JuniorTester() {
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
        return  "JuniorTester{ " + '\'' +
                super.toString() +
                " }"
                ;
    }
}
