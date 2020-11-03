package hello.demo;

import hello.demo.repository.JdbcMemberRepository;
import hello.demo.repository.MemberRepository;
import hello.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
* service, repository
* 개발자가 직접 등록한다.
* */
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean //service를 직접 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean //repository 직접 등록
    public MemberRepository memberRepository(){
        return new JdbcMemberRepository(dataSource);
    }
}
