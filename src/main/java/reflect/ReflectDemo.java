package reflect;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String s = "abc";
        Class<? extends String> c1 = s.getClass();
        System.out.println(c1.getName());

        Class<?> c2 = Class.forName("java.lang.String");
        System.out.println(c2.getName());

        Class<String> c3 = String.class;
        System.out.println(c3.getName());
    }
}
