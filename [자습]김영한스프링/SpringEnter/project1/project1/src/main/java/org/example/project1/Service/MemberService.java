package org.example.project1.Service;

import org.example.project1.domain.Member;
import org.example.project1.repository.MemberRepository;
import org.example.project1.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //회원가입
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //중복 확인
    private void validateDuplicateMember(Member member) {
        /**
//        //같은 이름의 중복 회원X
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        //^if null~이런 표현대신 Optional을 사용
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
         */

        //아님 위의 코드를 아래로 축약? 할수도있다.
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    //모든 멤버 찾기
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //특정멤버찾기
    public  Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
