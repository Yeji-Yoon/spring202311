package exam05;

public class Ex02 {
    Calculator cal = new Calculator() {
        @Override
        public int add(int num1, int num2) {
            return num1+num2;
        }
    };

    Calculator cal2 = (a,b) -> a+b;
}
