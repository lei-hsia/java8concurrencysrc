package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirCondition {

    private int number = 0;
    /*private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();*/

    public synchronized void increment() throws InterruptedException {
        while (number != 0) {
            this.wait(); //condition.await();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + number);
        // condition.signal(): IllegalMonitorStateException: 没有获取锁，却想释放锁
        this.notify(); // 否则不释放锁，一直等待
    }

    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            this.wait(); //condition.await();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + number);
        // condition.signal(): IllegalMonitorStateException: 没有获取锁，却想释放锁
        this.notify(); // 否则不释放锁，一直等待
    }
}

public class ProdConsumerThread {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    airCondition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "a").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    airCondition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "b").start();
    }
}
