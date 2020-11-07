package hello.demo;

import hello.demo.repository.MemberRepository;
import hello.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * service, repository
 * 개발자가 직접 등록한다.
 * */
@Configuration
public class SpringConfig {

    //spring data jpa
    private final MemberRepository memberRepository; //구현체 미리 만들어 놓은것이 자동으로 등록됨

    //생성자 1개니까 Autowired생략 가능하다.
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean //service를 직접 등록
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
/*
스프링 데이터 jpa는 따로 빈등록 안해도 됨.. 저절로 해줌..
    @Bean //repository 직접 등록
    public MemberRepository memberRepository() {

        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em); //entityManager필요함 : jpa
    }
 */
}
