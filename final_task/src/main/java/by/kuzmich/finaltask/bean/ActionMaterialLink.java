package by.kuzmich.finaltask.bean;

public class ActionMaterialLink {
    private int id;
    private int ActionId;
    private int MaterialId;

    public ActionMaterialLink(int id, int actionId, int materialId) {
        this.id = id;
        ActionId = actionId;
        MaterialId = materialId;
    }

    public int getId() {
        return id;
    }

    public int getActionId() {
        return ActionId;
    }

    public int getMaterialId() {
        return MaterialId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActionId(int actionId) {
        ActionId = actionId;
    }

    public void setMaterialId(int materialId) {
        MaterialId = materialId;
    }

    @Override
    public String toString() {
        return "ActionMaterialLink{" +
                "id=" + id +
                ", ActionId=" + ActionId +
                ", MaterialId=" + MaterialId +
                '}';
    }
}
