package com.bs.lec16;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(Model model){

        System.out.println("---home() method---");

        model.addAttribute("key","value1");

        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(Model model){
        System.out.println("---login() method---");

        model.addAttribute("key", "value2");

        return "login";
    }
}
