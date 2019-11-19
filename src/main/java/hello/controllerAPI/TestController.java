package hello.controllerAPI;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TestController {

    @GetMapping
    public String greetingsTest (){

        return "Hello there General Kenobi";
    }
}
