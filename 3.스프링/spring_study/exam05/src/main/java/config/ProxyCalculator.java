package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect //proxy를클래스로 사용할때
@Order(2)
public class ProxyCalculator {
    /*
    @Pointcut("execution(long aopex..*(long))")//경로패턴
    public void publicTarget() {}
    */
    //@Around("execution(* aopex..*(..))")
    @Around("CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        //Signature sig = joinPoint.getSignature();
        //System.out.println(sig.toLongString());
        //Object[] args = joinPoint.getArgs();
        //long num = (Long)args[0];
        //System.out.println(num);

        long stime = System.nanoTime();//공통 기능
        try {
            Object result = joinPoint.proceed();//핵심기능을 대신 수행하는 메서드
                //factorial
            return result;
        } finally {
            long etime = System.nanoTime();//공통기능
            System.out.printf("걸린 시간 : %d%n",etime-stime);
        }
    }
}
