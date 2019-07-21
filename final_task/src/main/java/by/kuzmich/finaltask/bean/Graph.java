package by.kuzmich.finaltask.bean;

import java.util.Set;

public class Graph {
    private String name;
    private Action node;
    private Set<Graph> actionSet;

    public Graph(Action node, Set<Graph> actionSet) {
        this.node = node;
        this.actionSet = actionSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getNode() {
        return node;
    }

    public void setNode(Action node) {
        this.node = node;
    }

    public Set<Graph> getActionSet() {
        return actionSet;
    }

    public void setActionSet(Set<Graph> actionSet) {
        this.actionSet = actionSet;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "node=" + node +
                ", actionSet=" + actionSet +
                '}';
    }
}
