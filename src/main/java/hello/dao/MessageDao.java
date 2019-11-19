package hello.dao;

import hello.model.Message;

import java.util.List;

public interface MessageDao {


    void newMessage(Message message);
    List<Message> selectAllMessages();
}
