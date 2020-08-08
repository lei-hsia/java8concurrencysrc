package netease;

import java.util.Scanner;

public class PrimeNumNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt(); // 有多少个数
        int res = 0;
        for (int i = 0; i < count; ++i) {
            int num = in.nextInt();
            if (num == 1) continue;
                // num为偶: res直接加上 num/2;
                // 为奇数: 3:res++; >3: res+= (num-3)/2;
            else if (num % 2 == 0) res += num/2;
            else {
                if (num == 3) res++;
                else {
                    res += (num - 3) / 2;
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
