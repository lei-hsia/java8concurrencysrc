package singleton;

/*  JVM创建对象:
        1. 分配对象内存空间
        2. 初始化对象
        3. 内存空间的地址赋值给对象的引用

        如果2 3重排序, 那么这个对象的引用就不为空了，但是实际上并没有初始化对象，那么第一个if进去之后拿到锁，此时singleton已经不为空了，
        就不会进入第二个if创建对象，直接返回singleton；但是实际上singleton指向的对象什么都没有
* */
public class DCLSingletonReorder {
    private static DCLSingletonReorder singleton;

    private DCLSingletonReorder() {}

    public static DCLSingletonReorder getInstance() {
        if (singleton == null) {
            synchronized (DCLSingletonReorder.class) {
                if (singleton == null) {
                    singleton = new DCLSingletonReorder();
                }
            }
        }
        return singleton;
    }
}

class Main1 {
    public static void main(String[] args) {
        DCLSingletonReorder instance = DCLSingletonReorder.getInstance();
        System.out.println(instance.toString());
    }
}
