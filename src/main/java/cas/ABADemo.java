package cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ABADemo {
    public static void main(String[] args) {

        System.out.println(" --- 导致ABA问题 --- ");
        AtomicReference<Integer> reference = new AtomicReference<>(100);
        new Thread(() -> {
            System.out.println(reference.compareAndSet(100, 101)+"\t"+reference.get());
            System.out.println(reference.compareAndSet(101, 100)+"\t"+reference.get());
        }, "t1").start();

        new Thread(() ->{
            try { TimeUnit.SECONDS.sleep(1); }catch (Exception e) { e.printStackTrace(); }
            System.out.println(reference.compareAndSet(100, 2020)+"\t"+reference.get());
            if (reference.get() == 2020) System.out.println("修改成功, 出现ABA问题");
        }, "t2").start();
    }
}
