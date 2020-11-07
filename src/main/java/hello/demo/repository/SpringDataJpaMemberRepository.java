package hello.demo.repository;

import hello.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { //pk 타입은 Long

    //인터페이스만 만들어 놓고, spring에서 제공하는 japRepository만 extends하면
    //구현체 자동으로 만들어서 Bean등록해준다.
    @Override
    Optional<Member> findByName(String name);
}
