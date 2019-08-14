package by.kuzmich.finaltask.bean;

import java.util.Objects;

public class GraphEdge {
    private int id;
    private Action parent;
    private Action child;

    public GraphEdge() {
    }

    public GraphEdge(int id, Action parent, Action child) {
        this.id = id;
        this.parent = parent;
        this.child = child;
    }

    public int getId() {
        return id;
    }

    public Action getParent() {
        return parent;
    }

    public Action getChild() {
        return child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphEdge)) return false;
        GraphEdge graphEdge = (GraphEdge) o;
        return getId() == graphEdge.getId() &&
                Objects.equals(getParent(), graphEdge.getParent()) &&
                Objects.equals(getChild(), graphEdge.getChild());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getParent(), getChild());
    }

    @Override
    public String toString() {
        return "GraphEdge{" +
                "id=" + id +
                ", parent=" + parent +
                ", child=" + child +
                '}' +
                '\n';
    }
}
