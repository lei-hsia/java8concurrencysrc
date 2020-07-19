package singleton;

public class DCLvolatileSingleton {

    // volatile禁止指令重排
    private static volatile DCLvolatileSingleton singleton;

    private DCLvolatileSingleton() {}

    public static DCLvolatileSingleton getInstance() {
        if (singleton == null) {
            synchronized (DCLvolatileSingleton.class) {
                if (singleton == null) {
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