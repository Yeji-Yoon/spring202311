package models.member;

import controllers.member.RequestLogin;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberDao memberDao;
    private final HttpSession session;


    public void login(RequestLogin form) {
        /**
         * 1. 아이디로 히원 조회
         * 2. 세션에 회원정보 유지
         *
         */

        String userId = form.userId();//ID가져옴
        Member member = memberDao.get(userId);

        session.setAttribute("member",member);

    }
}
