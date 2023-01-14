package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스만 있어도 JpaRepository를 Extend 한다면 스프링 데이터 JPA가 구현체를 만들어 스프링 빈에 자동으로 등록해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // findBy + {Name} : JPQL select m from Member m where m.name = ?
    // 인터페이스만으로도 간단한 쿼리들을 처리할 수 있다.
    @Override
    Optional<Member> findByName(String name);
}
