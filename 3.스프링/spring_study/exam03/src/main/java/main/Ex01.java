package main;

import config.AppCtx;
import config.AppCtx2;
import config.AppCtx3;
import config.AppCtx4;
import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx4.class);

        JoinService joinService = ctx.getBean(JoinService.class);//중복되지 않으면 .class만 명시해도 찾을수 있다.
        //getBean : 이름을 찾는것
        ListService listService = ctx.getBean("listService",ListService.class);

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);

        listService.print();

        ctx.close();
    }
}
