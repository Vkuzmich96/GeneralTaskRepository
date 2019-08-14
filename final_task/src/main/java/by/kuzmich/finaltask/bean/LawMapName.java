package by.kuzmich.finaltask.bean;

import java.util.Objects;

public class LawMapName {
    private int id;
    private String name;
    private boolean readiness;

    public LawMapName(int id, String name, boolean readiness) {
        this.id = id;
        this.name = name;
        this.readiness = readiness;
    }

    public LawMapName() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getReadiness() {
        return readiness;
    }

    public void setReadiness(boolean readiness) {
        this.readiness = readiness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LawMapName)) return false;
        LawMapName that = (LawMapName) o;
        return getId() == that.getId() &&
                getReadiness() == that.getReadiness() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getReadiness());
    }

    @Override
    public String toString() {
        return "LawMapName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", readiness=" + readiness +
                '}';
    }
}
