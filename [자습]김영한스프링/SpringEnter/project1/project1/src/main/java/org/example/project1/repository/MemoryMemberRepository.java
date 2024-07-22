package org.example.project1.repository;

import org.example.project1.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        //저장을 어딘가 해야하니까 위에 Map으로 임시 객체를 만들어서 거기에 저장
        member.setId(++sequence);
        //아이디를 시퀀스로 저장을 하고, 멤버도 저장
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //만약 return 결과가 null이면.. 오류가 날수도 있으니까
        //Nullable로 감싸서 전달
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //이름으로 같은걸 찾는거니까.. equals
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        //store.values == 멤버들
        return new ArrayList<>(store.values());
    }
}

//이렇게 작성한 코드들을 단독으로 테스트시키기 위해 테스트케이스를 이용한다.
//=> JUNIT
