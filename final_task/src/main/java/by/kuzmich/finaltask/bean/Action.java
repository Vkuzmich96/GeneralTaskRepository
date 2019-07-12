package by.kuzmich.finaltask.bean;

import java.util.List;

public class Action {
    private int id;
    private String instructions;
    private List<Material> materials;
    private User user;

    public Action(int id, String instructions, List<Material> materials, User user) {
        this.id = id;
        this.instructions = instructions;
        this.materials = materials;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getInstructions() {
        return instructions;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public User getUser() {
        return user;
    }
}
