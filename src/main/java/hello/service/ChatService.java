package hello.service;

import hello.dao.MessageDao;
import hello.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ChatService {

    private final MessageDao messageDao;


    @Autowired
    public ChatService(@Qualifier("postgres") MessageDao messageDao){
        this.messageDao = messageDao;
    }

    public void newMessage(Message message) {

        messageDao.newMessage(message);
    }




}
