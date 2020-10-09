package hello.hellospring.service;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    //private final DataSource dataSource; //데이터베이스 자동으로 생성
    //private EntityManager em;
    private final MemberRepository memberRepository;

    /*public SpringConfig(DataSource dataSource) {
        //this.dataSource = dataSource;
        this.em = em;
    }*/
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //스프링빈에 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
    /*
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    }*/
}
