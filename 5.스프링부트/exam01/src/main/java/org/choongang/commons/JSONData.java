package org.choongang.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@RequiredArgsConstructor//생성자 매개변수로 추가
//상수나 nonnull에서 필요
public class JSONData<T> {//어떤 데이터가 올지 모르기 때문에 제네릭을 씀
    private boolean success = true;
    private HttpStatus status = HttpStatus.OK; //응답상태 코드//200은 고정

    @NonNull
    private T data;//성공시 body데이터
    private String message;//실패시 메세지


}
