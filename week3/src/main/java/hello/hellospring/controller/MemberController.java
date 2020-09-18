package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//컴포넌트스캔
@Controller //컨트롤러가 객체를 미리 생성해줌
public class MemberController {
    private final MemberService memberService;

    //필드 주입 방식
    //@Autowired private MemberService memberService;

    //setter 주입 방식 - 중간에 바꾸면 문제가 생김
    /*@Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/

    //생성자 주입 방식 - 이 방식이 제일 좋음
    @Autowired //생성자와 연결
   public MemberController(MemberService memberService) { //생성자
        this.memberService = memberService;
    }
}

