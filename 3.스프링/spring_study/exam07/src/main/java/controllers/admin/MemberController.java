package controllers.admin;

import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import models.member.MemberNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminMemberController")//이름이 동일해서 충돌 이름 바꾸기
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberDao memberDao;

    @GetMapping // /admin/member
    public String index(@ModelAttribute MemberSearch serach, Errors errors, Model model) {

        List<Member> members = memberDao.getList(serach);

        model.addAttribute("members",members);

        members.forEach(System.out::println);

        return "admin/member/list";

    }

    // /admin/member/회원 아이디

    @GetMapping("/{id}")
    public String info(@PathVariable("id") String userId) {//경로 변수

        System.out.println(userId);

        return "admin/member/info";

    }

    @GetMapping("/test")
    public String errorTest() {
        boolean result = true;
        if(result) {
            //throw new RuntimeException("예외 발생!!!!");
            throw new MemberNotFoundException();
        }

        return "admin/member/info";
    }
/*
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model) {//membercontroller에만 해당하는 error

        e.printStackTrace();

        model.addAttribute("message",e.getMessage());

        return "error/common";
    }
*/
}
