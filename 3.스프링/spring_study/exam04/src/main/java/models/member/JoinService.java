package models.member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {//빈의 이름 joinService

    //@Autowired
    private final MemberDao memberDao;

    //@Autowired//의존성 자동주입
    @NonNull
    private JoinValidator validator;

    //통제 가능성을 주기 위해서 캡슐화 진행
    public void join(Member member) {
        //데이터 검증
        validator.validate(member);

        //데이터 추가
        memberDao.register(member);
    }
}
