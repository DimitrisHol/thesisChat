package hello.controllerAPI;


import hello.model.Message;
import hello.service.ChatService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
public class ChatLogController {


    private final ChatService chatService;

    public ChatLogController(ChatService chatService) {
        this.chatService = chatService;
    }

    @RequestMapping("/chatlog")
    public List<Message> chatLog() throws Exception {

        List<Message> recentMessages = chatService.returnRecentMessages();

        System.out.println(recentMessages.toString());

        return recentMessages;

    }
}
