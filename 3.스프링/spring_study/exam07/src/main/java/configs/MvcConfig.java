package configs;

import commons.Utils;
import controllers.member.JoinValidator;
import javassist.bytecode.analysis.Util;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.model.IComment;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc//설정 추가
@Import(DbConfig2.class)
//프록시(HandlerMapping,HandlerAdapter,ViewResolver한꺼번에 대신해줌
public class  MvcConfig implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext applicationContext;
/*
    @Autowired
    private JoinValidator joinValidator;


    @Override
    public Validator getValidator() {//모든 반환값의 전역 validator
        return joinValidator;
    }
*/
    @Bean
    public MemberOnlyInterceptor memberOnlyInterceptor() {
        return new MemberOnlyInterceptor();
    }

    @Bean
    public CommonInterceptor commonInterceptor(){
        return new CommonInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(memberOnlyInterceptor())
                .addPathPatterns("/mypage/**");

        registry.addInterceptor(commonInterceptor())
                .addPathPatterns("/**");//모든 경로가 commoninterceptor영향권안에 들어감.
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        //모든 요청 -> 컨트롤러 빈, 없는 경우 -> 정적 자원 경로(css,js,이미지)

    }



    @Override
    //정적 자원 경로
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")//모든 경로
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/upload/**")
            .addResourceLocations("file:///c:/uploads/"); // / 1개를 이스케이프 문자로 인식하고 날려버림

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index");

        registry.addViewController("/mypage/**")
                .setViewName("mypage/index");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);//Cacheable임시저장소에 저장//페이지 번역
        //true -> 최초 로딩시 번역, 다음 요청시에는 기존 파일을 그대로 사용
        //false ->  매번 요청시마다 다시 번역(개발중)
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true); //El식에대한 연산식 설정
        templateEngine.addDialect(new Java8TimeDialect()); //확장 기능 : Date Time API(java.time 패키지) - #temporals
        templateEngine.addDialect(new LayoutDialect());//확장기능 : 레이아웃 기능 추가
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding("utf-8");//고정
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) { // 최종설정
        registry.viewResolver(thymeleafViewResolver());
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setDefaultEncoding("UTF-8");
        ms.setBasenames("messages.commons","messages.validations");

        return ms;
    }

    @Bean
    public Utils utils() {

        return new Utils();
    }

    /*
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/",".jsp");
    }
     */

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        //PropertySources: Property 파일
        //PlaceholderConfigurer : 내용 치환 방식
        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(
                new ClassPathResource("application.properties")
        );

        return conf;
    }
}
