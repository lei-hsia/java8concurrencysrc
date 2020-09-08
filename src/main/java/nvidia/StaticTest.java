package nvidia;

public class StaticTest {
    static int cnt = 6;
    static {
        cnt += 9;
    }
    public static void main(String[] args) {
        System.out.println("cnt= " + cnt); // (6 + 9) / 3: 说明static不管是赋值还是代码块，就是从上往下运算的
    }
    static {
        cnt /= 3;
    };
}
