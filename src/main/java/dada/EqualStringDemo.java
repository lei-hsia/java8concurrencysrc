package dada;

public class EqualStringDemo {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        char[] s3 = {'a', 'b', 'c'};
        String s4 = new String("abc");
        // Integer

        System.out.println(s1.equals(s2)); // true
        System.out.println(s1 == s2);  // true
        System.out.println(s2.equals(s3)); // false
        System.out.println(s1.equals(s4)); // true
        System.out.println(s1 == s4); // false
        System.out.println(s1.equals(new String("abc"))); // true
    }
}
