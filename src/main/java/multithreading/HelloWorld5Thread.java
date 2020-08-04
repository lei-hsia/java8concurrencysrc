package multithreading;

import java.util.concurrent.TimeUnit;

// 5个线程打印hello world,要求所有线程都打印hello之后再打印world
public class HelloWorld5Thread {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final int integer = i;
            new Thread(() -> {
                System.out.println("hello " + integer);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("world "+integer);
            }, String.valueOf(i)).start();
        }
    }
}
