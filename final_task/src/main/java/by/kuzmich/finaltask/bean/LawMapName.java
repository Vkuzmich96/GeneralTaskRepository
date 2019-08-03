package by.kuzmich.finaltask.bean;

public class LawMapName {
    private int id;
    private String name;
    private boolean readiness;

    public LawMapName(int id, String name, boolean readiness) {
        this.id = id;
        this.name = name;
        this.readiness = readiness;
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
    public String toString() {
        return "LawMapName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", readiness=" + readiness +
                '}';
    }
}
