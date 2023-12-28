package models.member;

import controllers.admin.MemberSearch;
import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDao {


    @Autowired
    private final MemberMapper mapper;//상수//의존성 자동추가

    public boolean register(Member member) {
        int affectedRows= mapper.register(member);
        return  affectedRows > 0;//1이면등록이 성공
    }

    public boolean exist(String userId) {
        int cnt = mapper.exist(userId);
        return cnt>0;//1이상이면 이미 등록된 아이디
    }

    public Member get(String userId) {
        return mapper.get(userId);
    }

    public List<Member> getList(MemberSearch search) {
        LocalDate edate = search.getEdate();

        if (edate != null) {
            LocalDate newEdate = edate.plusDays(1);
            search.setEdate(newEdate);
        }

        return mapper.getList(search);
    }
}
