package by.kuzmich.finaltask.bean;

public enum Role {
    USER(0),
    ADMIN(1),
    LAWER(2);

    private int number;

    Role(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
