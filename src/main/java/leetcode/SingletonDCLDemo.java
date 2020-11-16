package leetcode;

public class SingletonDCLDemo {
    private static volatile SingletonDCLDemo singleton;

    private SingletonDCLDemo() {}

    public static SingletonDCLDemo getInstance(){
        if (singleton == null){
            synchronized (SingletonDCLDemo.class){
                if (singleton == null){
                    singleton = new SingletonDCLDemo();
                }
            }
        }
        return singleton;
    }
}

class MainDCL{
    public static void main(String[] args) {
        SingletonDCLDemo instance = SingletonDCLDemo.getInstance();
        System.out.println(instance.toString());
    }
}