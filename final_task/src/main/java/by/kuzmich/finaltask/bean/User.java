package by.kuzmich.finaltask.bean;

public class User {
    private int id;
    private String email;
    private String password;
    private Role role;
    private String name;
    private String address;
    private long number;

    public User(int id, String email, String password, Role role, String name, String address, long number) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getNumber() {
        return number;
    }
}
