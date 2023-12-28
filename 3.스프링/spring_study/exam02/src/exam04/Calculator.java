package exam04;

public abstract class Calculator {
    int num = 10;
    public abstract int add(int num1, int num2);
    //abstract를 쓰지 않으면 안됨.
    public void commonMethod() {
        System.out.println(("하위클래수의 공통"));
    }
}
