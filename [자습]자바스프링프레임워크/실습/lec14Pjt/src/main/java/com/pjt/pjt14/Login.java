package com.pjt.pjt14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){

        model.addAttribute("loginKey","loginValue");

        return "login"; //login.jsp
    }
}
