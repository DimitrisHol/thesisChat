package hello.controllerAPI;


import hello.model.Message;
import hello.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;



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

        chatService.newMessage(message);
//        return ("User : " + message.getAuthorName() + " sent " + message.getMessage());
        return message;

//        return new ChatService("User " + HtmlUtils.htmlEscape(message.getAuthorName()) + " said : " + HtmlUtils.htmlEscape(message.getMessage()));
    }
}
