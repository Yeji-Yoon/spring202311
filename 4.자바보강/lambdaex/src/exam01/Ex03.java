package exam01;

import java.util.concurrent.Callable;

public class Ex03 {
    public static void main(String[] args) {
        /*1.
        Calculator cal = new Calculator() {

            public int square(int num) {
                return num*num;
            }
        };

         */
        /*2.
        Calculator cal = (int num) -> {
            return num*num;
        };
         */
        /*
        Calculator cal = num -> num * num;
        */
        Calculator cal = x -> x * x;

        int result = cal.square(10);
        System.out.println(result);
    }

}
