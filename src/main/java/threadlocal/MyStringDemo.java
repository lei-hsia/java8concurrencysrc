package threadlocal;

import java.util.concurrent.CountDownLatch;

public class MyStringDemo {
    private String string;

    private String getString() {
        return string;
    }

    private void setString(String string) {
        this.string = string;
    }

    // 不一定有共享变量的问题, 可能并没有问题
    public static void main(String[] args) {
        int threads = 9;
        final MyStringDemo demo = new MyStringDemo();
        final CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {   // Thread(Runnable target, String name)
            Thread thread = new Thread(() -> {
               demo.setString(Thread.currentThread().getName());
                System.out.println(demo.getString());
                countDownLatch.countDown();
            }, "--"+i);

            thread.start();
        }
    }
}
