package hello.demo;

import hello.demo.repository.MemberRepository;
import hello.demo.repository.MemoryMemberRepository;
import hello.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* service, repository
* 개발자가 직접 등록한다.
* */
@Configuration
public class SpringConfig {

    @Bean //service를 직접 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean //repository 직접 등록
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
