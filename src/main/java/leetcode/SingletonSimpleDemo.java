package leetcode;

public class SingletonSimpleDemo {
    private static SingletonSimpleDemo singletonSimpleDemo; // static, private变量

    private SingletonSimpleDemo() {} // private构造方法

    public static SingletonSimpleDemo getInstance(){ // public, static getInstance()方法
        if (singletonSimpleDemo == null)
            singletonSimpleDemo = new SingletonSimpleDemo();
        return singletonSimpleDemo;
    }
}

class Main {
    public static void main(String[] args) {
        SingletonSimpleDemo instance = SingletonSimpleDemo.getInstance();
        System.out.println(instance);
    }
}