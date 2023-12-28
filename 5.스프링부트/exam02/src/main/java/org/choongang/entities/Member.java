package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.choongang.commons.MemberType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
//@Table(name = "USERS",indexes = @Index(name = "idx_member_createdAt", columnList ="createdAt DESC"))//USERS라는 이르므이 테이블 생성
//@EntityListeners(AuditingEntityListener.class)//이벤트 리스너를 감지해야함
public class Member extends Base{//엔티티는 기본적으로 클래스명

    @Id @GeneratedValue//기본키로서 없으면 오류
    private Long seq;

    @Column(length = 80,unique = true, nullable = false)//공통일때는 클래스 밖에다가 정의
    private String email;

    @Column(length = 40,nullable = false)
    private String name;

    @Column(length = 65, nullable = false)//상세한 설정
    private String password;//varchar2

    //@Lob
    //@Transient//내부에서만 쓰임
    //private String introduction;//CLOB:여러줄 텍스트를 입력할때

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private MemberType type;


    @ToString.Exclude//toString 메서드가 배제//참조 끊기
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)//boardData에 있는 멤벛
    private List<BoardData> items = new ArrayList<>();

    @OneToOne(fetch=FetchType.LAZY)//(fetch = FetchType.EAGER)//처음부터 조인
    @JoinColumn(name="addressNo")
    private Address address;

    /*
    //@CreationTimestamp//INSERT SQL싱행시
    @CreatedDate
    private LocalDateTime createdAt;

    //@UpdateTimestamp//UPDATE 실행시
    @LastModifiedDate
    private LocalDateTime modifiedAt;
*/
    //@Temporal(TemporalType.DATE)//날짜
    //@Temporal(TemporalType.TIME)//시간
    //@Temporal(TemporalType.TIMESTAMP)//날짜+시간
    //public Date dt;

}
