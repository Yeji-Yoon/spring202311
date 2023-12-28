package exam03;

public class Ex02 {
    public static void main(String[] args) {
        C c = new C(); //C -> C,B,A : 다형성
        //B,A는 C에 포함.
        A a = c; //a의 틀안의 c. 접근 가능한 데이터의 양은 A
        B b = c;//B의 틀 안의 c. 접근 가능한 데이터의 양은 B

        A aa = new C();


    }
}
