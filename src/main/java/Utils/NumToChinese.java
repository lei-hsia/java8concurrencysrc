package Utils;

import java.util.Scanner;

public class NumToChinese {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(toTraditionalChinese(input));
    }

    /*  FAILED TEST:
    *       8704375
            捌百柒十零 肆千叁百柒十伍
    * */
    public static String toTraditionalChinese(String str) {
        String[] s1 = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] s2 = {"十", "百", "千", "万" ,"十", "百", "千","亿" ,"十", "百", "千"};
        int n = str.length(), num = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            num = str.charAt(i) - '0';
            if (i != n - 1 && num != 0) {
                res += s1[num] + s2[n - 2 - i];
            } else {
                res += s1[num];
            }
        }
        return res;
    }
}
