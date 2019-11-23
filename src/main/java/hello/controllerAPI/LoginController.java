package hello.controllerAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*" , allowedHeaders = "*")
@Controller
public class LoginController {

//    private final LoginService loginService;
//
//    @Autowired
//    public LoginController (LoginService loginService){
//        this.loginService = loginService;
//    }
//
//    // A user enters the chat, sends a message to topic /login
//    // We temporarily log them into the userList data structure.
//    @MessageMapping("/login")
//    @SendTo("/topic/greetings")
//    public Message userLogin (User user , SimpMessageHeaderAccessor headAccessor) throws Exception{
//
////        System.out.println("We got your message " + user.getUsername());
//        // Websocket implementation to keep track of who is online? or something like that
//        headAccessor.getSessionAttributes().put("author" , user.getUsername());
//        loginService.userJoined(user);
//
//        Message message = new Message(user.getUsername(), "has joined the chat");
//        return message;
//    }
//
//
//    @MessageMapping("/logout")
//    public void userLogout (User user) throws Exception{
//
//        System.out.println("Received the user" + user.getId() + " " + user.getUsername());
//
//        loginService.userLeft(user);
//    }
}
