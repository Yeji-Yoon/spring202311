package controllers.member;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor//초기화 생성 변수. 생성자 매개변수 생성
public class MemberController {


    //@Autowired
    private final JoinValidator joinValidator;
    private final JoinService joinService;
    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("자바", "오라클","JSP","스프링");
    }
    @GetMapping("/join")// /member/join - RequestMapping이 공통적인 주소를 가져가서
    //@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})//requestmapping이 get과post를 한꺼번에 할수 있음.
    public String join(@ModelAttribute RequestJoin form,Model model) {//핸들러 아답터가  찾아서 알아서 지정

        //비어있는 객체도 추가 하는 방법

        //model.addAttribute("requestJoin",new RequestJoin());new RequestJoin() : NPE방지
        model.addAttribute("pageTitle", "회원가입");

        /*
        String[] addCss = {"member/style1","member/style2"};
        List<String> addScript = Arrays.asList("member/script1","member/script2");

        model.addAttribute("addCss",addCss);
        model.addAttribute("addScript",addScript);
        model.addAttribute("pageTitle","회원가입");

        Member member = Member.builder()
                .userNo(1L)
                .userPw("1234")
                .userId("user01")
                .userNm("<h1>사용자01</h1>")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .build();
        model.addAttribute("member", member);
        model.addAttribute("pageTitle","회원가입");
        */
        return "member/join";

    }

    @PostMapping("/join")
    //error는 command 객체 뒤에 있어야 함.중간에 껴도 안됨
    public String joinPs(@Valid RequestJoin form, Errors errors, Model model) {//@Valid : 검증이 진행되기 위해 꼭 필요

        //System.out.println(form);
        //커맨 객체 RequsetJoin -> requestJoin이름으로 속성이 추가 -> 템플릿 내에서 바로 접근가능

        //model.addAttribute("requestJoin",form);

        joinValidator.validate(form, errors);

        if(errors.hasErrors()) {//검증 실패시 다시 돌아감.
            return "member/join";
        }
        // 회원 가입 처리
        joinService.join(form);

        //response.sentRedirect(request.getContextPath()+"/member/login")
        //Locaton: 주소
        //return "redirect:/member/login";
        return "forward:/member/login";
    }


    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form) {

        return "member/login";
    }

    @PostMapping("/login")// /member/login
    public String loginPs(@Valid RequestLogin form, Errors errors) {

        loginValidator.validate(form,errors);
        //System.out.println(form);

        if(errors.hasErrors()) {
            return "member/login";
        }

        //로그인 처리
        loginService.login(form);

        return "redirect:/";//로그인 성공시 메인페이지로 이동
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();//세션 비우기//개인데이터를 비움.

        return "redirect:/member/login";//로그인 페이지 이동
    }

    @GetMapping("/list")// /member/list
    public String members(Model model) {

        List<Member> members = new ArrayList<>();
        for (int i=1; i<=10;i++) {
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userPw("1234")
                    .userId("user" + i)
                    .userNm("사용자" +i)
                    .email("user" + i + "@test.org")
                    .regDt(LocalDateTime.now())
                    .build();
            members.add(member);
        }

        model.addAttribute("members",members);

        return "member/list";
    }
    /*
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        //멤버에만 해당하는 공통 validator.controller에 해당하는 validator
        binder.setValidator(joinValidator);
    }

     */
}
