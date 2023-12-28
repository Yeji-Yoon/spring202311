package main;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int result = add(10, 20);
        System.out.println(result);

        int result2 = add(10, 20, 30, 40);
        System.out.println(result2);
    }

//    public static  int add(int num1, int num2) {
//        return num1 + num2;
//    }
//   public static  int add(int num1, int num2, int num3) {
//        return num1 + num2 + num3;
//   }
    public static  int add(int... nums) {

    //    System.out.println((Arrays.toString((nums))));
        /*
        int total = 0;
        for(int num : nums) {
            total +=total;
        }
        */
        int total = Arrays.stream(nums).sum();
        return total;
    }
}
