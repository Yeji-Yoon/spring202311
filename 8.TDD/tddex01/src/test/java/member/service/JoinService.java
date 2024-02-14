package member.service;

import commons.Validator;
import member.controllers.Member;

public class JoinService {

    private Validator<Member> joinValidator;


    public JoinService(Validator<Member> joinValidator) {
        this.joinValidator = joinValidator;
    }

    public void join(Member member) {
        joinValidator.check(member);

    }

    public void join(HttpservletRequest request) {
        Member member = Member.builder()
                .userId(request.getParameter("userId"))
                .userPw(request.getParameter("userPw"))
                .confirmPw(request.getParameter("cibfirmNm"))
                .userNm(request.getParameter("userNm"))
                .build();
    }

    //public void join(HttpServletRequest request) {

    //}
}