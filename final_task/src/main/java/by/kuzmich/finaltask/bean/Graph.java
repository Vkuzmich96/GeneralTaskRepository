package by.kuzmich.finaltask.bean;

import java.util.Objects;
import java.util.Set;

public class Graph {
    private String name;
    private Action node;
    private Set<Graph> actionSet;

    public Graph() {
    }

    public Graph(Action node, Set<Graph> actionSet) {
        this.node = node;
        this.actionSet = actionSet;
    }

    public Graph(String name) {
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Graph)) return false;
        Graph graph = (Graph) o;
        return Objects.equals(getName(), graph.getName()) &&
                Objects.equals(getNode(), graph.getNode()) &&
                Objects.equals(getActionSet(), graph.getActionSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNode(), getActionSet());
    }

    @Override
    public String toString() {
        return "Graph{" +
                "node=" + node +
                ", actionSet=" + actionSet +
                '}';
    }
}
