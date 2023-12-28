package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Human();
        animals[1] = new Dog();
        animals[2] = new Bird();

        for(Animal animal : animals) {
            animal.move();

            if(animal instanceof Human) { //안전하게 하기 위해 instanceof로 체크
                Human human = (Human)animal; //상위 클래스는 readBook이 없기 때문에 강제 형변환
                human.readBook();
            }

        }
    }
}
