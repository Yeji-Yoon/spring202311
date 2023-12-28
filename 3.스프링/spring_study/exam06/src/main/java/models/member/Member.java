package models.member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data @Builder//Builder를 쓰면 더 단순해짐.
public class Member {
    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String email;
    private LocalDateTime regDt;

}
