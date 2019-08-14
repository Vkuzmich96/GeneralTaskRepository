package by.kuzmich.finaltask.bean;

import java.util.List;
import java.util.Objects;

public class Action {
    private int id;
    private String name;
    private String instructions;
    private List<Material> materials;
    private User user;

    public Action(int id, String name, String instructions, List<Material> materials, User user) {
        this(id);
        this.name = name;
        this.instructions = instructions;
        this.materials = materials;
        this.user = user;
    }

    public Action(int id) {
        this.id = id;
    }

    public Action() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action)) return false;
        Action action = (Action) o;
        return getId() == action.getId() &&
                Objects.equals(getName(), action.getName()) &&
                Objects.equals(getInstructions(), action.getInstructions()) &&
                Objects.equals(getMaterials(), action.getMaterials()) &&
                Objects.equals(getUser(), action.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getInstructions(), getMaterials(), getUser());
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", name=" + name +
                ", instructions='" + instructions + '\'' +
                ", materials=" + materials +
                ", user=" + user +
                '}';
    }
}
