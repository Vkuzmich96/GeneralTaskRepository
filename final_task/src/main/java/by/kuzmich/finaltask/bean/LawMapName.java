package by.kuzmich.finaltask.bean;

public class LawMapName {
    private int id;
    private String name;

    public LawMapName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "LawMapName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
