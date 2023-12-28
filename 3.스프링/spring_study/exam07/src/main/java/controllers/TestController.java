package controllers;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TestController {

    @GetMapping("/cookie/test1")
    public String test1(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("key1","value1");
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie("key2", "value2");
        cookie2.setPath(request.getContextPath()); // /exam07

        cookie2.setMaxAge(60 * 60 * 24 * 7);
        //cookie2.setMaxAge(0);//1970.1.1자정- 쿠키삭제
        cookie2.setHttpOnly(true);//false -  자바스크립트로 브라우저에서 조회 가능
                                    //true - 자바스크립트 조회x, 서버에서만 조회를 통한 출력가능

        response.addCookie(cookie2);



        return "test";
    }

    @GetMapping("/cookie1/test2")//getMapping
    public String test2(@CookieValue(name = "key2", defaultValue = "기본값") String key2) {//requestParameter랑 비슷
        System.out.printf("key2=%s%n",key2);//개별 쿠키값 조회
        return "test";
    }

    @GetMapping("/session/test1")
    public String test3(HttpSession session) {
        session.setAttribute("key1", "value1");

        return "test";
    }

    @GetMapping("/session/test2")
    public String test4(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String value = (String)session.getAttribute("key1");
        System.out.printf("key1=%s%n", value);
        return "test";
    }
}
