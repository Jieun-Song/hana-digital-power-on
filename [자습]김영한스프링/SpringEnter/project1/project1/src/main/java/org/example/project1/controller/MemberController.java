package org.example.project1.controller;

import org.example.project1.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;
    //여러개 생성할 필요없이 그냥 하나 선언해서 다같이 돌려쓴다.

    @Autowired//위 MemberService가 생성될떄 자동으로 아래도 같이 생성됨.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



}


