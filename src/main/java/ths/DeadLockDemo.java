package ths;

public class DeadLockDemo {
    public static String lock1 = "lock1";
    public static String lock2 = "lock2";

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (DeadLockDemo.lock1){
                System.out.println("get: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DeadLockDemo.lock2){
                    System.out.println("get: "+ Thread.currentThread().getName());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (DeadLockDemo.lock2){
                System.out.println("get: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DeadLockDemo.lock1){
                    System.out.println("get: "+ Thread.currentThread().getName());
                }
            }
        });


        t1.start();
        t2.start();
    }
}
