package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {
    Member save(Member member); //회원저장
    Optional<Member> findById(Long id); //id로 회원을 찾음
    Optional<Member> findByName(String name); //이름으로 회원을 찾음
    List<Member> findAll(); //지금까지 저장된 회원리스트 반환
}
