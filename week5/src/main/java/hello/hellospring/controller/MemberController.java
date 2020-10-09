package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new") //데이터 등록할때 보통 post를 씀, 조회는 get방식
    public String create(MemberForm form) {
        Member member = new Member(); //멤버생성
        member.setName(form.getName());

        memberService.join(member); //회원가입

        return "redirect:/"; //"/"으로 url요청
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers(); //멤버를 다 가져옴
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

