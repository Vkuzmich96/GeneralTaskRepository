package by.kuzmich.finaltask.bean;

import java.util.Objects;

public class Material {
    private int id;
    private String url;
    private String description;
    private String name;

    public Material(int id, String url, String discription, String name) {
        this.id = id;
        this.url = url;
        this.description = discription;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDiscription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDiscription(String discription) {
        this.description = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;
        Material material = (Material) o;
        return getId() == material.getId() &&
                Objects.equals(getUrl(), material.getUrl()) &&
                Objects.equals(description, material.description) &&
                Objects.equals(getName(), material.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUrl(), description, getName());
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", discription='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
