package exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
//효율성 때문에 buffer를 비우지 않음.
public class Ex05 {
    public static void main(String[] args) {
        byte[] buffer = new byte[5];

        try (FileInputStream fis = new FileInputStream("test2.txt")) {
            while (fis.available() > 0) {
                int ch = fis.read(buffer);//ch-현재 읽어온 바이트 갯수
                for (int i = 0; i < buffer.length; i++) {
                    System.out.println(buffer[i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}