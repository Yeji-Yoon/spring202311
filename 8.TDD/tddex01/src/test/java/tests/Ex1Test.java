package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;

public class Ex1Test {

    @TempDir
    private File tmpFile;

    @Test
    void test1() {
        System.out.println(tmpFile.getAbsolutePath());
    }

    @Test
    @Timeout(3)
    void test2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
    }
}
