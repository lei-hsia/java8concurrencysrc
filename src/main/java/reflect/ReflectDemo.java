package reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // Spring反射极致用的很多: 因为都是容器在运行时读取XML/JavaBean中的类或者对象的信息
        /*
            反射生成Class对象的三种方式: Class.forName(); obj.getClass(); someClass.class
        * */
        String s = "abc";
        Class<? extends String> c1 = s.getClass();
        System.out.println(c1.getName());

        Class<?> c2 = Class.forName("java.lang.String");
        System.out.println(c2.getName());

        Class<String> c3 = String.class;
        System.out.println(c3.getName());

        /* 反射生成java对象的两种方式: someClass.newInstance; someClass.class.getConstructor().newInstance() */
        Class<?> c4 = Class.forName("User");
        User userObj1 = new User();
        Object userObj2 = c4.getConstructor().newInstance();
    }
}
