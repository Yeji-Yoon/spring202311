package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    @Autowired
    //@Qualifier("memberDao")
    private MemberDao memberDao;
    @Autowired //의존주입이 필요한 것을 알려주는 @, 의존성 자동주입
    private JoinValidator validator;

    public JoinService() {}

    //setter를 통한주입,
    public JoinService(MemberDao memberDao, JoinValidator validator) {
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
