package controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller//요청과 응답처리할수 있는 관리 객체.
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name",defaultValue = "기본값") String nm, Model model) {

        model.addAttribute("name", nm);

        return "hello";
    }
    /*
    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response, HttpSession session){
    //public String hello(@RequestParam("name") String name,@RequestParam("num") int num) {
        //System.out.println(name+","+num);
        System.out.println("request : " + request);
        System.out.println("response : " + response);
        System.out.println("session : "+session);

        return "hello";// /WEB-INF/templates/hello.jsp
    }
    */
    /*
    //handeler mapping이 찾아옴.
    //viewResolver로 보내줌
    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        //request.setAttribute("message","안녕하세요")
        // request범위의 속성이 추가
        mv.addObject("message", "안녕하세요.");
        mv.setViewName("hello"); // /WEB-INF/templates/hello.jsp

        return mv;
    }
     */

}
