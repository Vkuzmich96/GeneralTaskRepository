package by.kuzmich.finaltask.bean;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActionMaterialLink)) return false;
        ActionMaterialLink that = (ActionMaterialLink) o;
        return getId() == that.getId() &&
                getActionId() == that.getActionId() &&
                getMaterialId() == that.getMaterialId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getActionId(), getMaterialId());
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
