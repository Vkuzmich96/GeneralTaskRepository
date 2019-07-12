package by.epam.entity.tester;

import by.epam.entity.Position;

public class TeamLeadTester extends Tester {

    public TeamLeadTester(String name, int experience, int Salary, TestingKind testingKind, int id) {
        super(Salary, Position.TEAM_LEAD, name, experience, testingKind, id);
    }

    public TeamLeadTester() {
        super(Position.TEAM_LEAD);
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
        return  "TeamLeadTester{ " + '\'' +
                super.toString() +
                " }"
                ;
    }
}
