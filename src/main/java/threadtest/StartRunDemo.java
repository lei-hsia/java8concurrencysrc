package threadtest;

class RunDemo extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

/*
*   NEW -start-> RUNNABLE -run-> RUNNING
*   start才能把创建的线程变为就绪状态：真正的创建调用新线程: 而run直接调用是JVM直接调用，那么是运行当前线程，并不是创建了新线程
* */
public class StartRunDemo {
    public static void main(String[] args) {
        RunDemo thread1 = new RunDemo();
        thread1.run(); // main
        System.out.println(Thread.currentThread().getName());
        RunDemo thread2 = new RunDemo(); // main
        thread2.start(); // Thread-1
    }
}
