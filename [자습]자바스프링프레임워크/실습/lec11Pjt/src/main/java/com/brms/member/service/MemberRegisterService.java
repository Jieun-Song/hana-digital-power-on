package com.brms.member.service;

import com.brms.member.Member;
import com.brms.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;
    public MemberRegisterService() {}
    public void register(Member member){
        memberDao.insert(member);
    }
}
