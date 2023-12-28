package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        String[] words = {"aaa","aaa","bb","cc","abcd","abcd"};

        Arrays.stream(words).distinct().filter(s ->s.length() >=3).forEach(System.out::println);

        List<String> word2 = Arrays.asList("aaa","aaa","bb","cc","abcd","abcd");
        word2.stream().distinct().filter(s ->s.length() >= 3).forEach(System.out::println);
    }
}
