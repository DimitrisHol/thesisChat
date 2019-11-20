package hello.controllerAPI;
import hello.model.Message;
import hello.model.User;
import hello.service.ChatService;
import hello.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*" , allowedHeaders = "*")
@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController (LoginService loginService){
        this.loginService = loginService;
    }

    // A user enters the chat, sends a message to topic /login
    // We temporarily log them into the userList data structure.
    @MessageMapping("/login")
    public void messageLog (User user , SimpMessageHeaderAccessor headAccessor) throws Exception{

        System.out.println("We got your message " + user.getUsername());
        // Websocket implementation to keep track of who is online? or something like that
        headAccessor.getSessionAttributes().put("author" , user.getUsername());
        loginService.userJoined(user);
    }
}
