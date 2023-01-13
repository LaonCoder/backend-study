package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


// 스프링 컨테이너와 스프링 빈이 생성될 때 아래와 같은 @Controller 어노테이션이 붙어있는
// 멤버 컨트롤러 객체들은 생성되어 스프링이 관리를 받는다.
// 이를 스프링 컨테이너에서 스프링 빈을 관리한다고 한다.
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired  // memberService를 스프링 컨테이너에 있는 MemberService를 가져와 연결시켜 준다. (DI)
    public MemberController(MemberService memberService) {
        // memberService를 찾을 수 없다는 애러 → MemberService는 스프링 컨테이너가 관리하는 객체가 아닌 일반 클래스이기 때문
        // → MemberService 클래스 위에 '@Service'라는 어노테이션을 붙여준다.
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    // MemberForm form의 멤버 변수인 name에 Post 방식으로 받은 name 데이터가 저장된다.-
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";  // 홈 화면으로 리다이렉션 된다.
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);  // 모델에 저장한다.
        return "members/memberList";
    }
}
