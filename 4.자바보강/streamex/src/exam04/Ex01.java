package exam04;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};

        int total = Arrays.stream(nums).reduce(0, (acc,num) -> {
            System.out.printf("acc=%d, num=%d%n",acc,num);// num ; 순서대로 들어옴

            acc +=num;//기존반환값에 지금 값을 추가


            return acc;

        });

        System.out.println(total);
    }
}
