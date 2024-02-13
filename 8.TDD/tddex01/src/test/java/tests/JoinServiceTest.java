package tests;

import member.controllers.Member;
import member.service.BadRequestException;
import member.service.JoinService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("회원 가입 기능 테스트")
public class JoinServiceTest {

    @BeforeAll // 모든 테스트 케이스 실행전 1번 실행
    static void beforeAll() {
        System.out.println("BEFORE ALL");
    }

    @AfterAll // 모든 테스트 케이스 실행 완료 후 1번 실행
    static void afterAll() {
        System.out.println("AFTER ALL");
    }

    @BeforeEach // 각각의 테스트 케이스 실행 전 호출
    void beforeEach() {
        System.out.println("BEFORE EACH");
    }

    @AfterEach // 각각의 테스트 케이스 실행 후 호출
    void afterEach() {
        System.out.println("AFTER EACH");
    }

    private Member getMember() {
        return
    }

    @Test
    @DisplayName("회원 가입 성공시 예외 발생 없음")
    void joinSuccess() {
        assertDoesNotThrow(() -> {
            joinService.join(getMember());
        });
    }

    @Test
    @DisplayName("필수 입력항목(userId, userPw, confirmPw, userNm) 검증, 실패시에는 BadRequestException 발생")
    void requiredField() {
        assertThrows(BadRequestException.class, () -> {
            /* userId 검증 - null, 빈값 */
            Member member = getMember();
            member.setUserId(null);
            joinService.join(member);

            member = getMember();
            member.setUserId("   ");
            joinService.join(member);
        });
    }
}
