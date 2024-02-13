package config;

import aopex.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)//설정 코드//새로운 프록시 객체 만들어지고 다 들어감
public class AppCtx {

    @Bean
    public RecCalculator calculator() {

        return new RecCalculator();
    }
    public ProxyCache proxyCache() {
        return new ProxyCache();
    }
    @Bean
    public ProxyCalculator proxyCalculator() {
        return new ProxyCalculator();
    }
}
