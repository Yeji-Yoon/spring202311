package proxyex;

public class RecCalculator implements Calculator{
    @Override
    public long factorial(long num) {
        long stime = System.nanoTime();
        if(num<1L){
            return 1L;
        }
        return num*factorial(num-1);
        //재귀(Recursive) : 본인 함수를 계속 호출 스택에 계속 쌓여서 성능 저하
    }
}
