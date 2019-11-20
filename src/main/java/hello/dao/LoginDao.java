package hello.dao;

import hello.model.User;

public interface LoginDao {

    void userLoggedIn(User user);
    void userLoggedOut(User user);
}
