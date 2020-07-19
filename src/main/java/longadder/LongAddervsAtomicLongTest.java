package longadder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAddervsAtomicLongTest {
    public static void main(String[] args) {
        testLongAdderVSatomicLong(1, 10000000);
        testLongAdderVSatomicLong(10, 10000000);
        testLongAdderVSatomicLong(20, 10000000);
        testLongAdderVSatomicLong(40, 10000000);
        testLongAdderVSatomicLong(80, 10000000);
    }

    private static void testLongAdderVSatomicLong(final int threadCount, final int time) {
        try {
            System.out.println("threadCount: " + threadCount + ",time: " + time);
            long start = System.currentTimeMillis();
            testLongAdder(threadCount, time);
            System.out.println("LongAdder elapse: " + (System.currentTimeMillis() - start) + "ms");

            System.out.println("threadCount: " + threadCount + ",time: " + time);
            long start2 = System.currentTimeMillis();
            testAtomicLong(threadCount, time);
            System.out.println("LongAdder elapse: " + (System.currentTimeMillis() - start2) + "ms");

            System.out.println();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testAtomicLong(int threadCount, int time) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(); // N个线程，increment这个共享变量
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < time; j++) {
                    atomicLong.getAndIncrement();
                }
            }));
        }

        for (Thread thread : list) { // start at the same time
            thread.start();
        }

        for (Thread thread: list) {
            thread.join();
        }
    }

    private static void testLongAdder(int threadCount, int time) throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < time; j++) {
                    longAdder.add(1);
                }
            }));
        }

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }
    }

}
