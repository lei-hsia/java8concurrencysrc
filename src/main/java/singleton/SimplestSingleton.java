package singleton;

/*  饿汉模式: 简单单例模式写法，有线程安全问题
    singleton:
        1. 类构造器private
        2. 持有自己类型的属性
        3. 对外提供获取instance的静态方法
* */
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