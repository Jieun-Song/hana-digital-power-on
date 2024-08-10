package com.bs.lec16;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(Model model){

        model.addAttribute("key","value");
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(Model model){

        return "login";
    }
}
