package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //저장할 공간 생성
    private static long sequence = 0L; //key값을 생성해줌

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id값 넣어줌
        store.put(member.getId(), member); //store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //NULL일 경우 처리
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //name이 서로 같은지 확인
                .findAny(); //찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store에 저장된 것 반환
    }

    public void clearStore() {
        store.clear();
    }
}
