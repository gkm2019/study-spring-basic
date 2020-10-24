package hello.demo.repository;

import hello.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    //optional : java-8에 들어간 기능이다. findById가 Null을 반환할 경우
    //optional 로 감싸서 반환한다.
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
