package by.kuzmich.finaltask.bean;

public class Material {
    private int id;
    private String url;
    private String discription;

    public Material(int id, String url, String discription) {
        this.id = id;
        this.url = url;
        this.discription = discription;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDiscription() {
        return discription;
    }
}
