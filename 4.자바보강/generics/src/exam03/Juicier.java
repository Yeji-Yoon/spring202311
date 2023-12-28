package exam03;

import exam02.Fruit;

public class Juicier {

    //메서드 중복 정의 - 와일드 카드:<?>로 제거
    //<Apple> : 형식적 오류이기 때문에 컴파일 시에는 제거
   /*
    public static void make(FruitBox<Apple> appleBox) {

    }

    public static void make(FruitBox<Pear> pearBox) {

    }
    */
    public static void make(FruitBox<? super Apple> fruitBox) {
        System.out.println(fruitBox.getItems());
    }
    public static <T extends Fruit> void make(FruitBox<T> fruitBox) {
        System.out.println(fruitBox.getItems());
    }

}
