package org.example.springpracticeproject.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainView(){
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // home.jsp 파일을 반환
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
