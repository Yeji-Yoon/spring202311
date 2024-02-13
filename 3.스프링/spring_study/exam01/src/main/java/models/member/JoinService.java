package models.member;

public class JoinService {

    private MemberDao memberDao;
    private JoinValidator validator;

    //setter를 통한주입,
    public JoinService(MemberDao memberDao, JoinValidator validator

    ) {
        this.memberDao = memberDao;
        this.validator = validator;
    }

    //통제 가능성을 주기 위해서 캡슐화 진행
    public void join(Member member) {
        //데이터 검증
        validator.validate(member);

        //데이터 추가
        memberDao.register(member);
    }
}
