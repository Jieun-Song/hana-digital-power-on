package org.example.springpracticeproject.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainView(){
        return "welcome";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
