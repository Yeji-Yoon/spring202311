package models.member;

import controllers.member.RequestJoin;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final MemberDao memberDao;

    public void join(RequestJoin form) {//데이터를 영구적으로 담음.

        String hash = BCrypt.hashpw(form.getUserPw(), BCrypt.gensalt(12));//gtsalt : 해쉬를 몇번 반복해서 만들것인가



        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(hash)
                .userNm(form.getUserNm())
                .email(form.getEmail())
                .build();

        memberDao.register(member);
    }
}
