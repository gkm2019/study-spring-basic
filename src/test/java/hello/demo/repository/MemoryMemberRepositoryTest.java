package hello.demo.repository;

import hello.demo.domain.Member;
import hello.demo.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    @DisplayName("test 실행되기 전에 수행한다.")
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    @DisplayName("test가 하나씩 끝나면 저장소 지워주는 함수 (콜백메서드)")
    //test 순서는 보장되지 않는다 그렇기 때문에 하나의 테스트가 끝날 때 마다 저장소 비워주는게 좋다.
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("저장 실행")
    public void save(){
        Member member = new Member();
        member.setName("springName");
        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        //매번 이렇게 글씨를 출력할 순 없다! -> assert 사용한다!
        //System.out.println("result= "+ (result==member));
        //Assertions.assertEquals(member, result); //member랑 result랑 같은가? (같으면 성공, 다르면 실패 뜸)

        //assertj 사용 버전
        assertThat(member).isEqualTo(result); //member가 result랑 똑같은가?
    }

    @Test
    @DisplayName("findByName test")
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    @DisplayName("findAll 테스트")
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
