package org.example.project1.Service;

import org.assertj.core.api.Assertions;
import org.example.project1.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class MemberServiceTest {

    MemberService memberService = new MemberService();
    @Test
    void join() {
        //given 뭐가 주어졌을때
        Member member = new Member();
        member.setName("hello");

        //when 이거를 실핼했을때
        Long saveId = memberService.join(member);

        //then 이게 나와야해
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복회원_예외() {
        //테스트명은 한글로 해도 무관하다.
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        try{
            memberService.join(member2);
            fail("예외가 발생해야 합니다.");
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}