package hello.dao;

import hello.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userList")
public class LoginAccessService implements LoginDao {

    private static List<User> userList = new ArrayList<>();

    @Override
    public void userLoggedIn(User user) {

        userList.add(user);

        System.out.println("Active users are : ");
        for (User user1 : userList){
            System.out.println(user1.getUsername());
        }

    }

    @Override
    public void userLoggedOut(User user) {

    }
}

