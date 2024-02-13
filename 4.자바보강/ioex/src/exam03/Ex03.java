package exam03;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);//버퍼와 인풋을한번에
       System.out.print("아무거나 입력 : ");
       String str = sc.next();
       System.out.println(str);
    }
}
