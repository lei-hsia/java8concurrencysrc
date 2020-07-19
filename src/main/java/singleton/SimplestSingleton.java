package singleton;

public class SimplestSingleton {
    private static SimplestSingleton singleton;

    private SimplestSingleton() {}

    // 因为是static静态方法，所以是类名.getInstance()直接调用
    public static SimplestSingleton getInstance() {
        if (singleton == null) {
            singleton = new SimplestSingleton();
        }

        return singleton;
    }
}

class Main {
    public static void main(String[] args) {
        SimplestSingleton instance = SimplestSingleton.getInstance();
        System.out.println(instance.toString());
    }
}