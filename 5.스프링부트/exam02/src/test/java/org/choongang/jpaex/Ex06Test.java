package org.choongang.jpaex;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.BoardData;
import org.choongang.entities.Member;
import org.choongang.entities.QBoardData;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")//메모리 기반 Db여서  테스트에 부담이 줄어듬
public class Ex06Test {

    @Autowired
    private BoardDataRepository boardDataRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");

        memberRepository.saveAndFlush(member);
/*
        BoardData data = new BoardData();
        data.setSubject("제목1");
        data.setContent("내용1");
        data.setMember(member);

        boardDataRepository.saveAndFlush(data);
    */
        List<BoardData> items = new ArrayList<>();
        for(int i=1; i<=10; i++) {
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setMember(member);
            items.add(item);
        }

        boardDataRepository.saveAllAndFlush(items);
        em.clear();//엔티티 비우기
    }


    @Test
    void test1() {
        BoardData data = boardDataRepository.findById(1L).orElse(null);
        Member member = data.getMember();//게시글에서 회원 조회
        String email = member.getEmail();//2차 쿼리
        System.out.println(email);
        //System.out.println(member);
    }

    @Test
    void test2() {
        Member member = memberRepository.findByEmail("user01@test.org");
        List<BoardData> items = member.getItems();

        System.out.println(items);
        items.forEach(System.out::println); //BoardData -> toString() : 참조변수가 알아서 붙음
    }

    @Test
    void test3() {
        List<BoardData> items = boardDataRepository.findAll();//1차쿼리 실행
        for(BoardData item : items) {
            Member member = item.getMember();
            String email = member.getEmail();//2차 쿼리 실행
        }
    }
    @Test
    void test4() {
        //List<BoardData> items = boardDataRepository.getSubjects("목");
        List<BoardData> items = boardDataRepository.findBySubjectContaining("목");
    }

    @Test
    void test5() {
        QBoardData boardData = QBoardData.boardData;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);


        List<BoardData> items = jpaQueryFactory.selectFrom(boardData)
                .leftJoin(boardData.member)
                .fetchJoin()
                .where(boardData.subject.contains("목"))
                .fetch();

        items.forEach(System.out::println);
    }
}
