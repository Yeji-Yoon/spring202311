package exam02;

public class Outer {
    Calculator method(int num3) {
        //공간을 4byte나 할당하기때문에 불필ㅇ
        return new Calculator() {//익명 내부 클래스
            public int add(int num1, int num2) {
                //num3 = 40; //상수가 될필요가 있다.
                return num1 + num2 +num3;
            }
        };

     //   return cal;
    }
/*
        int result = cal.add(10,20);
        System.out.println(result);
    }

    void method() {
        class Inner {
            void innerMethod() {
                System.out.println("지역 내부 클래스 !!");

            }
        }

        Inner in = new Inner();
        in.innerMethod();

    }*/
}
