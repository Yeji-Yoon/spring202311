package exam01;

import java.util.ArrayList;
import java.util.Arrays;

public class ex01 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");
        names.add("이름6");

        //참조 변수만 호출해도 toString이 정의 되어 있어서 데이터를 볼수 있다.
        System.out.println(names);
    }
}
