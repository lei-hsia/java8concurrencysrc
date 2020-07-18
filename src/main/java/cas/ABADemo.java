package cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

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

        try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) { e.printStackTrace(); }

        /* atomicStampedReference: stamp: + version control: fix ABA*/
        System.out.println(" --- 解决ABA问题 --- ");
        AtomicStampedReference<Integer> stampedReference =
                new AtomicStampedReference<>(100, (int)System.currentTimeMillis());

        int stamp = stampedReference.getStamp();
        System.out.println(stamp);

        // 修改成功或者失败: stampedReference.compareAndSet: 返回true/false
        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(stampedReference.compareAndSet(
                    100, 101, stamp, stamp+1));
            System.out.println(stampedReference.compareAndSet(
                    101, 100, stampedReference.getStamp(), stampedReference.getStamp()+1));
            System.out.println(stampedReference.getStamp());
        }, "t3").start(); // 启动线程

        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(7); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(stampedReference.compareAndSet(
                    100, 2020, stamp, stamp+1));
            System.out.println(stampedReference.getStamp());
        }, "t4").start();
    }
}
