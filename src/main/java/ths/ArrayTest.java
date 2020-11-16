package ths;

public class ArrayTest {
    public static void main(String[] args) {
        char[] ch1 = new char[2];
        ch1[0] = 'a';
        ch1[1] = 'b';

        char[] ch2 = new char[2];
        ch1[0] = 'a';
        ch1[1] = 'b';

        System.out.println(ch1.equals(ch2));
    }
}
