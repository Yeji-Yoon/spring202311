package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class BoardData extends Base{

    @Id
    @GeneratedValue
    private Long seq;

    @Column(length = 100, nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String content;
    //private String createdAt;
    //private String modifiedAt;

    @ManyToOne(fetch=FetchType.LAZY)//다대일 관계//join자동 처리
    @JoinColumn(name = "userNo")//기본키 : seq//"userNo"는 외래키 명
    private Member member;

    @ManyToMany(fetch=FetchType.LAZY)
    private List<HashTag> tags = new ArrayList<>();


}
