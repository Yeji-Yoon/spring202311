package commons;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;


public class Utils {
    @Autowired
    private HttpSession session;

    public boolean isLogin() {
        return  getMember() != null;//세션에 값이 있으면 로그인 상태
    }

    public Member getMember() {
        Member member = (Member)session.getAttribute("member");//세션에 있는 값을 받아옴

        return member;
    }
    /*
    public String toUpper(String str){
        return str.toUpperCase();
    }
    */

}
