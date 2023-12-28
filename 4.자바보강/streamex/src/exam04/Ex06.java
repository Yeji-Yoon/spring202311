package exam04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex06 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple","Orange","Mango","Melon");

        String str = fruits.stream().collect(Collectors.joining(","));
        System.out.println(str);
    }
}
