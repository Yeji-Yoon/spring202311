package models;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//InitializingBean, DisposableBean는 우리가 작성한거
//destory는 외부에서 가져오는것
public class Message implements InitializingBean, DisposableBean {
    //객체 설정
    public void send(String message) {
        System.out.printf("전송 메세지 : %s%n", message);
    }
    @Override
    public void afterPropertiesSet(){
        System.out.println("afterPropertiesSet()!!");
    }

    @Override
    public void destroy() throws Exception {
        //스프링 컨테이너에 있는 빈 소멸전 -> 호출
        //자원해제를 주로 많이 처리
        System.out.println("destroy()!!");
    }
}
