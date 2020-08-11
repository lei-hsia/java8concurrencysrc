package singleton;

public class DCLvolatileSingleton {

    // volatile禁止指令重排
    private static volatile DCLvolatileSingleton singleton;

    private DCLvolatileSingleton() {}

    public static DCLvolatileSingleton getInstance() {
        if (singleton == null) {
            synchronized (DCLvolatileSingleton.class) {
                if (singleton == null) { // DCL，防止多线程都进入第一个if这里没有检验，创建多个单例实例
                    singleton = new DCLvolatileSingleton();
                }
            }
        }
        return singleton;
    }
}

class Main2 {
    public static void main(String[] args) {
        DCLvolatileSingleton instance = DCLvolatileSingleton.getInstance();
        System.out.println(instance.toString());
    }
}