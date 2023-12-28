package org.choongang.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
//기본생성자가 추가(편법으로)NoArgsConstructor  : 기본생성자추가(매개변수가 없음)AllArgsConstructor : 모든 매개변수를 초기화하는 생성자  required : 초기화가 반드시 필요한 생성자 만듬(nonnull, final,
// )

public class Member {

    @Id//Primary Key : 기본키로 쓰임
    private Long userNo;

    private String userId;
    @JsonIgnore
    private String userPw;
    private String userNm;
    private String email;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime modDt;


}
