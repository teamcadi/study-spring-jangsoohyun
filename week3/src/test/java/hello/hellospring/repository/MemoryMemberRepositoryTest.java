package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.JsonPathAssertions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() { //test가 끝날때 마다 초기화
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member(); //멤버 생성
        member.setName("spring"); //이름 넣어줌

        repository.save(member); //저장
        //제대로 저장됐는지 확인
       Member result = repository.findById(member.getId()).get(); //저장된 값 가져옴
       assertThat(member).isEqualTo(result); //member 와 result 비교
    }

    @Test
    public void findByName() {
        //멤버저장
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        //멤버생성
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
