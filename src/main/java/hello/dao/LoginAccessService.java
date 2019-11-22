package hello.dao;

import hello.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("userList")
public class LoginAccessService implements LoginDao {

    private static List<User> userList = new ArrayList<>();

    @Override
    public void userLoggedIn(User user) {

        userList.add(user);
        printUsers();

    }

    @Override
    public void userLoggedOut(User user) {

        for (User user1 : userList){
            if (user1.getUsername().equals(user.getUsername())){
                userList.remove(user1);
            }
        }
        printUsers();


    }

//    public Optional<User> selectUserByName(String name){
//
//        return userList.stream()
//                .filter(user -> user.getUsername().equals(name))
//                .findFirst();
//
//    }

    public void printUsers(){

        System.out.println("Active users are : ");
        for (User user1 : userList){
            System.out.println(user1.getId() + " " +user1.getUsername());
        }
    }
}

