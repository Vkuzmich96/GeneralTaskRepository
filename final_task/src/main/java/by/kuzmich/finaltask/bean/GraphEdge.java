package by.kuzmich.finaltask.bean;

public class GraphEdge {
    private int id;
    private Action parent;
    private Action child;

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
    public String toString() {
        return "GraphEdge{" +
                "id=" + id +
                ", parent=" + parent +
                ", child=" + child +
                '}';
    }
}
