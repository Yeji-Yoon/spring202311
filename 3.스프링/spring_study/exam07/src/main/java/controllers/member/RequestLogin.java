package controllers.member;

import jakarta.validation.constraints.NotBlank;

public record RequestLogin(//한번 값이 들어오면 수정이 안됨 : 상수 형태
        @NotBlank
        String userId,

        @NotBlank
         String userPw
) {}
