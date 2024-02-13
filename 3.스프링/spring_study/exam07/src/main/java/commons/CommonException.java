package commons;

import org.springframework.http.HttpStatus;

//에러 상태 코드
public class CommonException extends RuntimeException {//관리자 페이지 : 공통 에러

    private HttpStatus status;

    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);//500// 메시지 던짐

        //status = HttpStatus.INTERNAL_SERVER_ERROR;

    }

    public CommonException(String message,HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
