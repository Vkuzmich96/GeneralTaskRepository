package by.kuzmich.finaltask.bean;

public class ActionMaterialLink {
    private int id;
    private int actionId;
    private int materialId;

    public ActionMaterialLink(int id, int actionId, int materialId) {
        this(actionId, materialId);
        this.id = id;
    }

    public ActionMaterialLink(int actionId, int materialId) {
        this.actionId = actionId;
        this.materialId = materialId;
    }

    public int getId() {
        return id;
    }

    public int getActionId() {
        return actionId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Override
    public String toString() {
        return "ActionMaterialLink{" +
                "id=" + id +
                ", ActionId=" + actionId +
                ", MaterialId=" + materialId +
                '}';
    }
}
