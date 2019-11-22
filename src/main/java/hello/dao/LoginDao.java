package hello.dao;

import hello.model.User;

import java.util.Optional;

public interface LoginDao {

    void userLoggedIn(User user);
    void userLoggedOut(User user);

}
