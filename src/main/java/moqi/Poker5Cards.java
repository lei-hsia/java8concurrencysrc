package moqi;

import java.util.Arrays;

/**
* 设计并实现一个扑克系统, 不算大王小王输入任意张扑克，输出是否有同花顺 (5 张 的同花顺才算）
**/

public class Poker5Cards {
    public static void main(String[] args) {
        System.out.println(test(new int[]{32, 33, 34, 37, 35, 3, 5, 4, 2, 1}));
    }

    // 0-12, 13-25, 26-38, 39-51
    public static boolean test(int[] pokes) {
        if (pokes == null || pokes.length == 0) return false;
        int len = pokes.length;
        if (len <= 4) return false;
        Arrays.sort(pokes);

        int count = 0;
        for (int i = 0; i < len; ++i) {
            if ((pokes[i]==13 || pokes[i]==26 || pokes[i]==39) && count<5) {  // 换种思路，断点的时候一定要count>=5
                count = 1;
                continue;
            }
        if (pokes[i]+1 == pokes[i+1]) count++;
        if (count>=5) return true;
    }

        return false;
    }
}
