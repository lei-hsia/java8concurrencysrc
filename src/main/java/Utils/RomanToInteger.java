package Utils;

import java.util.*;

/*
*   RomanToInteger: TraditionalChineseToInteger: same way
* */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V',5); map.put('X', 10); map.put('L', 50);
        map.put('C', 100); map.put('D',500); map.put('M',1000);
        char[] ch = s.toCharArray();
        int res = 0;

        for (int i = 0; i < ch.length; ++i) {
            // 比较i i+1: 规避i到最后一位的特殊情况: 用i==ch.length-1 短路后面的判断
            if (i == ch.length - 1 || map.get(ch[i]) >= map.get(ch[i+1])) res += map.get(ch[i]);
            else res -= map.get(ch[i]); // 减: 因为此时这一位比较小的数应该是归于后面要减的部分
        }
        return res;
    }
}