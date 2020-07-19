package singleton;


/* 静态内部类创建对象；getInstance方法中直接返回这个对象
*  因为是classloader方式加载实例化对象，所以同一时间只能有一个线程加载这个类，所以即使重排序也没有问题 */
public class InnerclassSingleton {
    private static class SingletonHolder {
        public static InnerclassSingleton singleton = new InnerclassSingleton();
    }

    public static InnerclassSingleton getInstance() {
        return SingletonHolder.singleton;
    }
}

class Main3 {
    public static void main(String[] args) {
        InnerclassSingleton instance = InnerclassSingleton.getInstance();
        System.out.println(instance.toString());
    }
}