package hello.model;

import java.util.ArrayList;

public class User {

    //TODO change it to UUID
    private final int id;
    private final String username;

    //Maybe ArrayList with messages, we'll see

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
