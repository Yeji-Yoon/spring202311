package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.BoardData;
import org.choongang.entities.HashTag;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.HashTagRepository;
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
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex08Test {

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private HashTagRepository hashTagRepository;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        List<HashTag> tags = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            HashTag tag = new HashTag();
            tag.setTag("태그" + i);
            tags.add(tag);//영구성 안에 있지 않음.
        }

        hashTagRepository.saveAllAndFlush(tags);

        List<BoardData> items = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setTags(tags);//태그 조회가능
            items.add(item);//영구성 컨테스트안에 들어가 있음.영구성 안에 있으면 쿼리를 두번 안해도 됨.
        }

        boardDataRepository.saveAllAndFlush(items);//영속성 안에 있음
        em.clear();//영속성 비우기//다시 쿼리 할수 있게
    }

    @Test
    void test1() {
        BoardData item = boardDataRepository.findById(1L).orElse(null);
        List<HashTag> tags = item.getTags();
        System.out.println(tags);
    }

    @Test
    void test2() {
        HashTag tag = hashTagRepository.findById("태그1").orElse(null);
        List<BoardData> items = tag.getItems();
        items.forEach(System.out::println);
    }
}
