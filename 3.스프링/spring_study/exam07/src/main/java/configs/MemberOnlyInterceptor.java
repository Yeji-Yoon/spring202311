package configs;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.member.Member;
import org.springframework.web.servlet.HandlerInterceptor;

public class MemberOnlyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();//request쪽에 session이 들어있음.
        Member member = (Member)session.getAttribute("member");

        if(member != null) {//로그인 상태
            return true;
        }


        //비회원 -> 로그인 페이지 이동
        //response.setStatus(401);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        String url = request.getContextPath() + "/member/login";//ContextPath() : 주소 고정(/exam07)
        response.sendRedirect(url);

        return false;//인터셉터가 설정될 url
    }
}
