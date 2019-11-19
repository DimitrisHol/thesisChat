package hello.dao;

import hello.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository("fakeDao")
public class ChatMessageAccessService implements MessageDao{

    private static List<Message> DB = new ArrayList<>();


    @Override
    public void newMessage(Message message) {
        DB.add(message);

        System.out.println("Added" +message.toString());

        if (message.getMessage().equals("all")){
            System.out.println(DB);
        }

    }

    @Override
    public List<Message> selectAllMessages() {
        return DB;
    }
}
