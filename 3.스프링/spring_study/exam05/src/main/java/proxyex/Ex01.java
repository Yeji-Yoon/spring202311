package proxyex;

public class Ex01 {
    public static void main(String[] args) {

        long stime = System.nanoTime(); //공통기능
        //핵심기능
        ImplCalculator cal1 = new ImplCalculator();
        //재귀방식은 본인 함수를 계속 호출 스택에 쌓여서 성능이 떨어짐,
        //반복은
        long result1 = cal1.factorial(10L);
        System.out.printf("cal1 : %d%n",result1);

        long etime = System.nanoTime(); //공통기능
        System.out.printf("걸린 시간 : %d%n",etime-stime);

        stime = System.nanoTime();//공통 기능

        //핵심 기능
        RecCalculator cal2 = new RecCalculator();
        long result2 = cal2.factorial(10L);
        System.out.printf("cal2 : %d%n", result2);

        etime = System.nanoTime();//공통 기능
        System.out.printf("걸린 시간 : %d%n", etime-stime);
    }
}
