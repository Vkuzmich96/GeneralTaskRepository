package by.epam.entity;

import java.util.List;
import java.util.UUID;

public class Team {
    private String teamID;
    private List<Employee> employees;

    public Team (List<Employee> employees){
        this.employees = employees;
        teamID = UUID.randomUUID().toString();
    }

    public String getTeamID() {
        return teamID;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Team ");
        string.append(teamID);
        string.append('{');
        string.append('\n');
        for (Employee employee : employees){
            string.append(" employee - ").append(employee).append('\n');
        }
        string.append('}');
        return string.toString();
    }
}
