package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
/*
@ComponentScan(value = "models",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes=ManualBean.class))
@ComponentScan(value = "models",
        excludeFilters = @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,
        classes = MemberDao.class))

 */
//@ComponentScan(value = "models", excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,
//pattern = "models..*Dao"))//.. : 하위패키지를 포함한 모든 패캐지
@ComponentScan("models")
public class AppCtx {
    /*
    @Bean //이름이 동일한 경우 수동 등록 Bean이 자동 등록AutoWired보다 우선 순위가 더 높다
    public MemberDao memberDao() {
        System.out.println("수동 등록빈!!!");
        return new MemberDao();
    }
    */

}
