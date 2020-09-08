package baidu;

import java.util.ArrayList;
import java.util.Scanner;
public class ClimbStairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[] f = new int[n+1]; // f[n]表示到第n个台阶可能有多少种方法
            ArrayList<Integer> list= new ArrayList<>(); // 记录每次跨越的台阶数目

            f[1] = 1; // 1个台阶，只有1种方式
            f[2] = 1; // 2个台阶，只有1种方式: 一次跨越2台阶
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (j != list.get(list.size()-1) && j != list.get(list.size()-2)) {
                        f[n] += f[n - m];
                    }
                    list.add(j);
                }

            }

            System.out.println(f[n] % (1e9 + 7));
        }
    }
}