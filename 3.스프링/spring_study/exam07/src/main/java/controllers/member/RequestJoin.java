package controllers.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class RequestJoin {
    //@NotBlank(message = "아이디를 입력하세요.")
    @NotBlank
    @Size(min=6)
    private String userId;

    @NotBlank
    @Size(min=8)
    private String userPw;

    @NotBlank
    private String confirmPw;

    @NotBlank
    private String userNm;
    @Email
    private String email;//이메일 형식으로 검증
    //private List<String> hobby;//String[] hobby; set<String> hobby;
    //private Address addr; //중첩된 커맨드 객체 addr.address
    @AssertTrue
    private boolean agree;
}
