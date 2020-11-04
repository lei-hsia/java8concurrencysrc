package deutsch;

import java.util.List;

public class ThreadTest {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("HI");
        new Thread(r).start();
    }

    // public int getClient(List<? extends Number> myParam);
}
