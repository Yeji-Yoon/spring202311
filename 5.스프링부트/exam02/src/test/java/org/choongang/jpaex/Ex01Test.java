package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01Test {
    @PersistenceContext//jpa에 맞게 의존 자동 주입
    private EntityManager em;

    @BeforeEach
    void init() {
        Member member = new Member();
        //member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자 01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());


        em.persist(member);//영속성 컨텍스트에 영속 상태 - 변화감지 시작
        em.flush();
        em.clear();;//영속 상태 엔티티 모두 비유ㅣ기
    }
    @Test
    void test1() {//조회 메소드
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setName("사용자 01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());


        em.persist(member);//영속성 컨텍스트에 영속 상태 - 변화감지 시작
        em.flush();

        em.detach(member);//영속성 분리 - 변화감지x

        member.setName("(수정)사용자01");
        em.flush();

        em.merge(member); //분리된 영속 상태 엔터티 ->영속 상태: 변화감지 o
        em.flush();

/*
        em.remove(member);//제거상태로 변경//제거가 아님
        em.flush();

 */
    }
    @Test
    void test2() {
        Member member = em.find(Member.class, 1L); // SQL 실행 -> 엔티티 -> 영속 상태
        System.out.println(member);

        Member member2 = em.find(Member.class, 1L); // 영속 상태 엔티티 -> 조회
        System.out.println(member2);
    }
    @Test
    void test3() {
        List<Member> members = em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
        members.forEach(System.out::println);
    }

}
