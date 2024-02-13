package mapper;

import controllers.admin.MemberSearch;
import models.member.Member;


import java.util.List;

public interface MemberMapper {

    int register(Member member);
    int exist(String userId);

    Member get(String userId);//프록시 형태로 구현체 ㅊ가

    List<Member> getList(MemberSearch search);
}
