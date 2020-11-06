package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//인터페이스 다중 상속 가능, 스프링데이터는 알아서 구현체 만들어줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //select m from Member where m.name=?
    @Override
    Optional<Member> findByName(String name);
}