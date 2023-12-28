package exam01;

import static exam01.Transportation.*;

public class Ex01 {
    public static void main(String[] args) {
        Transportation bus = Transportation.BUS;
        System.out.println(BUS == BUS);
        System.out.printf("ordinal() : %d, name() : %s%n",bus.ordinal(),bus.name());
    }
}
