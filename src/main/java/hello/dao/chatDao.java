package hello.dao;

import hello.model.Message;
import hello.model.User;

import java.util.List;

public interface chatDao {


    Message newMessage(Message message);
    List<Message> selectRecentMessages();
    void userLoggedIn(User user);
    void userLoggedOut(User user);
}
