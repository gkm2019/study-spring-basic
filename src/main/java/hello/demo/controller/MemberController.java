package hello.demo.controller;

import hello.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //memberService를 가져다 연결 시켜준다. 의존성 주입DI(dependency injection)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
