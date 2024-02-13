package exam03;


import exam03.FruitBox;

public class Ex01 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();

        appleBox.add(new Apple());//Apple, Fruit, Object
        appleBox.add(new Apple());
        appleBox.add(new Pear());

        Juicier.make(appleBox); //이때 형이 결정

        FruitBox<Object> pearBox = new FruitBox<>();
        pearBox.add(new Pear());
        pearBox.add(new Pear());

        Juicier.make(pearBox);

    }
}
