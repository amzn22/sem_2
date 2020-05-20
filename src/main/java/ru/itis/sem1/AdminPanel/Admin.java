package ru.itis.sem1.AdminPanel;

public class Admin {

    private final long id;
    private final String name;

    public Admin(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
