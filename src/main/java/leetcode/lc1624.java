package leetcode;

import java.util.HashMap;

public class lc1624 {
    public static int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int mx = -1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                mx = Math.max(mx, i - map.get(c) - 1);
            } else map.put(c, i);
        }
        return mx;
    }

    public static void main(String[] args) {
        int i = maxLengthBetweenEqualCharacters("somerandomstring");
    }
}
