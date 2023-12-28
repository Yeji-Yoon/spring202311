package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(1)
public class ProxyCache {

    private Map<Long,Object> cacheData = new HashMap<>();



    @Around("CommonPointcut.publicTarget()")//같은 패키지 일때는 클래스명을 입력하지 않아도 됨.(config 생략)
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs(); //매개변수로 투입된 인자 값(예-10L)
        Long num = (Long) args[0];
        if(cacheData.containsKey(num)) {
            System.out.println("캐시값 사용!");
            return cacheData.get(num);
        }
        Object result = joinPoint.proceed();//핵심기능 대신 수행
        //ProxyCalculator

        //캐시 저장
        cacheData.put(num,result);
        System.out.println("캐시 저장!");

        return result;
    }
}
