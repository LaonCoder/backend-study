package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;


public class JpaMemberRepository implements MemberRepository{

    // '...-data-jpa' 라이브러리를 사용할 경우 스프링 부트가 자동으로 EntityManager를 만들어 준다. → DI 받는다!
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // JPQL이라는 쿼리 언어. PK를 사용하지 않는 쿼리인 경우 작성해야 한다.
        // 아래의 쿼리에선 'm'을 통해 멤버 자체를 select 한다.
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
    }
}
