package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//자동 등록할 bean을 알려주는 힌트
public class ListService {

    private MemberDao memberDao;

    @Autowired//바로 주입되지 않고 매개변수 형식으로 주입,
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void print() {
        List<Member> members = memberDao.getList();
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
