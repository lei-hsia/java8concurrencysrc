package stringdemo;

public class ObjectJudge {
    public static void main(String[] args) {
        String a = "some";
        String b = "some";
        String c = "some";

        String a1 = new String("some");
        String b1 = new String("some");
        String c1 = new String("some");

        // String创建出来的对象都放在字符串常量池，相同的就不重复创建了；new对象在堆内存中，会先去常量池中找，有就不重复创建了
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(a1.hashCode());
        System.out.println(a1.hashCode());
        System.out.println(c1.hashCode());
    }
}
