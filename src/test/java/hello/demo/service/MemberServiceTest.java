package hello.demo.service;

import hello.demo.domain.Member;
import hello.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    @DisplayName("test 실행되기 전에 수행한다.")
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("회원가입")
    void join() {
        //Given
        Member member = new Member();
        member.setName("spring");

        //When
        Long saveId = memberService.join(member);

        ///Then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    @DisplayName("중복 회원 예외하기")
    public void validateDuplicateMember() {
        //Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//예외가 발생해야함 그럼 체크해줌
        //assertThrows(NullPointerException.class, () -> memberService.join(member2)); //Null 반환해야 체크해줌

/*
//try catch문은 너무 지저분함.
        try{
            memberService.join(member2); //illegalState예외가 던져짐
            fail("예외가 발생해야 합니다.");
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); //Service에서 보내는 예외메시지랑 같아야함(다르면 test fail)
        }
*/
        //Then
    }

    @Test
    @DisplayName("회원 검색")
    void findMembers() {
    }

    @Test
    @DisplayName("회원 id로 검색")
    void findOne() {
    }
}