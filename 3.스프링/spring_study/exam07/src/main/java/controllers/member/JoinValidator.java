package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.MemberDao;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberDao memberDao;

    @Override
    public boolean supports(Class<?> clazz) {//검증 커맨드 객체를 제한

        return clazz.isAssignableFrom(RequestJoin.class);
    }

    /**
     * 실제로 검증을 수행할 메서드
     * @param target the object that is to be validated //검증할 커멘드 객체
     * @param errors contextual state about the validation process // 검증 실패시 에러 정보를 처리
     */
    @Override
    public void validate(Object target, Errors errors) {//에러 정보가 담김//직접 정보를 담음.
        /**
         * 1. 필수 항목 검증(userId,uerPw,confirmPw,userNm,agree)
         * 2. 중복 아이디 여부 체크
         * 3. 아이디 최소 자리수(6자리 이상) 체크
         * 4. 비밀번호 최소 자리수(8자리 이상) 체크
         * 5. 이메일 값은 필수는 아니지만 값이 있으면 필수체크
         * 6. 비밀번호, 비밀번호 확인 일치여부
         */
        RequestJoin form = (RequestJoin) target;

        //중복 아이디 여부 체크
        String userId = form.getUserId();
        if(StringUtils.hasText(userId) && memberDao.exist(userId)){//이미 가입된 아이디
            errors.rejectValue("userId","Duplicated");
        }

        String userPw = form.getUserPw();
        String confirmPw = form.getConfirmPw();

        if(StringUtils.hasText(userPw) && StringUtils.hasText(confirmPw)&&!userPw.equals(confirmPw)){
            errors.rejectValue("confirmPw","Mismatch");
        }
/*
        boolean result = false;
        if(!result) {
            errors.reject("ErrorTest","공통에러....");
        }
*/
        /*
        String userId = form.getUserId();
        String userPw = form.getUserPw();
        String confirmPw = form.getConfirmPw();
        String userNm = form.getUserNm();
        boolean agree = form.isAgree();

        if(userId == null || userId.isBlank()){

        }

        if(!StringUtils.hasText(userId)){
            errors.rejectValue("userId","Required","아이디를 입력하세요");

        }
        if(!StringUtils.hasText(userPw)) {
            errors.rejectValue("userPw","Required","비밀번호를 입력하세요.");
        }
        if(!StringUtils.hasText(confirmPw)) {
            errors.rejectValue("confirmPw","Required","비밀번호를 확인하세요.");
        }
*/

/*
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userid","Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userPw","Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"confirmPw","Required");
*/
    }
}