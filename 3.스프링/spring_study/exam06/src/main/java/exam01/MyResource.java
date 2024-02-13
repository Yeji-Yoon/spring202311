package exam01;

public class MyResource implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("자원해제...");
    }
}
