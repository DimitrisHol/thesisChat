package hello.dao;

import hello.model.Message;
import hello.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository("fakeDao")
public class ChatMessageAccessService implements chatDao {

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
    public List<Message> selectRecentMessages() {
        return DB;
    }

    @Override
    public void userLoggedIn(User user) {

    }

    @Override
    public void userLoggedOut(User user) {

    }
}
