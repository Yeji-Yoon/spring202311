package org.choongang.jpaex;

import org.choongang.entities.BoardData;
import org.choongang.entities.Member;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "spring.profile.active=test")
public class Ex09Test {

    @Autowired
    private BoardDataRepository repository;//회원쪽에 연결

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        Member member = new Member();
        member.setEmail("user0!@test.org");
        member.setPassword("12345678");
        member.setName("사용자01");

        memberRepository.saveAndFlush(member);

        List<BoardData> items = new ArrayList<>();
        for(int i =1 ;i<3;i++) {
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setMember(member);
            items.add(item);
        }

        repository.saveAllAndFlush(items);
    }

    @Test

    void test1() {
        Member member = memberRepository.findByEmail("user01@test.org");//영속성 안에 가져옴.
        memberRepository.delete(member);//가져온 다음에 삭제
        memberRepository.flush();//영구 저장
    }
}
