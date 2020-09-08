package baidu;

import java.util.Scanner;

// 5的个数肯定是9个倍数，0加在后面
public class Product90 {
    public static void main(String[] args) {
        int totalNum = 0; // 一共多少个数
        int num0 = 0, num5 = 0; // 0有多少个，5有多少个
        Scanner in = new Scanner(System.in);
        totalNum = in.nextInt();
        if (totalNum < 9) {
            System.out.println(-1);
        }
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if (num == 0) num0++;
            else if (num == 5) num5++;
        }

        System.out.println(totalNum);
        System.out.println(num0);
        System.out.println(num5);
        if (num5 < 9) {
            System.out.println("222");
            System.out.println(-1);
        }
        // num5 >= 9
        String res = "";
        for (int i = 0; i < num5 / 9; i++) {
            res += "5";
        }
        for (int i = 0; i < num0; i++) {
            res += "0";
        }
        System.out.println(res);
    }

}

/*public class Product90 {
    static int totalNum = 0; // 一共多少个数
    static int num0 = 0, num5 = 0; // 0有多少个，5有多少个
    public static void main(String[] args) {
        System.out.println(run());
    }

    public static String run() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            totalNum = in.nextInt();
            if (totalNum < 9) {
                System.out.println("11111");
                return String.valueOf(-1);
            }
            if (in.nextInt() == 0) num0++;
            if (in.nextInt() == 5) num5++;
        }
        System.out.println(num0);
        System.out.println(num5);
        if (num5 < 9) {
            System.out.println("222");
            return String.valueOf(-1);
        }
        // num5 >= 9
        String res = "";
        for (int i = 0; i < num5 / 9; i++) {
            res += "5";
        }
        for (int i = 0; i < num0; i++) {
            res += "0";
        }
        return res;
    }
}*/

