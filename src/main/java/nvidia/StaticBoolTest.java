package nvidia;

public class StaticBoolTest {
    private static int j = 0;

    private static Boolean methodB(int k) {
        j += k;
        return true;
    }

    public static void methodA(int i) {
        boolean b;
        b = i < 10 | methodB(4); // 六种位运算符: & 按位与 | 按位或 ^ 按位异或 ~ 取反 << 左移 >> 右移
        System.out.println("---");
        b = i < 10 || methodB(8); // 或: i<10, 对后面短路了, 不进行计算
        System.out.println(">>>");
    }

    public static void main(String[] args) {
        methodA(0);
        System.out.println(j); // 4
    }
}
