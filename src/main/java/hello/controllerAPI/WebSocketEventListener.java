package hello.controllerAPI;


import hello.model.Message;
import hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.sql.Timestamp;

@Component
public class WebSocketEventListener {


    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    // User send the first connection message, not already connected.
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        System.out.println("Received a new websocket connection apparently.");
    }


    // User Disconnected
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {

        // We get the name of the user that disconnected from the chat, and then we send an appropriate message.
        StompHeaderAccessor headers = StompHeaderAccessor.wrap(event.getMessage());
        String author = (String) headers.getSessionAttributes().get("author");


        if (author != null) {

            // Send a message to the chat the user has left the channel
            Message chatMessage = new Message(author, "has left the chat",  new Timestamp(System.currentTimeMillis()));
            messagingTemplate.convertAndSend("/topic/greetings", chatMessage);

            User user = new User(0 , author);

            System.out.println(user.getUsername() + " " + user.getId());

            System.out.println("We are sending " + user + user.getUsername() + user.getId());
            messagingTemplate.convertAndSend("/logout", user);
        }
    }
}
