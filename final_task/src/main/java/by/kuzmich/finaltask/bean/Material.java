package by.kuzmich.finaltask.bean;

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
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", discription='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
