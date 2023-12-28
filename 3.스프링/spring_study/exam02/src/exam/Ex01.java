package exam;

public class Ex01 {
    public static void main(String[] args) {
        //생성자 함수(메소드) = 객체를 생성하는 역할(힙 메모리에 필요한 자원을 위한 공간 할당)
        //new 힙에 공간을 만듬
        //배열 : 같은 자료형 연속된 공간
        // int[] nums = new int[3];
        C c = new C();// C,B,A
        A a = c;
        B b = c;
        //다양하게 형변환 출처가 명확함.

        A a2 = new C();

    }
}
