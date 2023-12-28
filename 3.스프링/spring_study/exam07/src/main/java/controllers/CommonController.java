package controllers;

import commons.CommonException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers")
public class CommonController {
    @ExceptionHandler(Exception.class)//controller의 에러 유입
    public String errorHandler(Exception e, Model model, HttpServletResponse response) {
//내가 정한 예외는 메시지 출력(commons/CommonException), 아니면 500출력

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;//500
        if(e instanceof CommonException){//응답 코드 출력
            CommonException commonException = (CommonException) e;
            status = commonException.getStatus();
        }

        response.setStatus(status.value());

        e.printStackTrace();

        model.addAttribute("message", e.getMessage());

        return "error/common";
    }
}

