package hello.controllerAPI;


import hello.model.Message;
import hello.model.User;
import hello.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@CrossOrigin(origins = "*" , allowedHeaders = "*")
@Controller
public class ChatController {

    private final ChatService chatService;


    @Autowired
    public ChatController (ChatService chatService){
        this.chatService = chatService;
    }

    // A user sends a message at topic "/hello"
    // We reply to topic  "/hello"

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message messageLog (Message message) throws Exception{

        return chatService.newMessage(message);

    }

    // A user enters the chat, sends a message to topic /login
    // We temporarily log them into the userList data structure.
    @MessageMapping("/login")
    @SendTo("/topic/greetings")
    public Message userLogin (User user , SimpMessageHeaderAccessor headAccessor) throws Exception{

        // Add the user to the database if he isn't there already, and mark him as active.
        chatService.userJoined(user);

        // Set the name of the user to notify chat when he leaves.
        headAccessor.getSessionAttributes().put("author" , user.getUsername());


        String authorUsername = user.getUsername();
        String content = "has joined the chat";

        Date date= new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);

        // Send a notification to the chat that the user has joined the chat.
        Message message = new Message(authorUsername, content, timestamp);

        return message;
    }

    @MessageMapping("/chatlogrequest")
    @SendTo("/topic/chatlogresponse")
    public List<Message> chatLog (User user) throws Exception{

        System.out.println(user.toString());

        // Populate the chat with 10 past messages.  (new method, receive the list, loop to populate it, in the end we are returning a list of Messages, not a simple message.)
        List<Message> recentMessages = chatService.returnRecentMessages();

        System.out.println(recentMessages.toString());

        return recentMessages;

    }


    // Handle when the user leaves the chat. (It is invoked by the WebSocketEventListener class)
    @MessageMapping("/logout")
    public void userLogout (User user) throws Exception{

        System.out.println("Received the user" + user.getId() + " " + user.getUsername());

        chatService.userLeft(user);
    }



}
