package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class lc1625LexigraficalSmallest {
    public static String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String smallest = s;
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        Set<String> seen = new HashSet<>(q);
        while (!q.isEmpty()){
            String cur = q.poll();
            if (smallest.compareTo(cur) > 0) {
                smallest = cur;
            }
            char[] ca = cur.toCharArray();
            for (int i = 1; i < ca.length; i += 2) {
                ca[i] = (char)((ca[i] - '0' + a)% 10 + '0');
            }
            // move b
            String rotate = cur.substring(n-b) + cur.substring(0, n-b);
            if (seen.add(rotate))
                q.offer(rotate);
            //
            String addA = String.valueOf(ca);
            if (seen.add(addA))
                q.offer(addA);
        }
        return smallest;
    }

    public static void main(String[] args) {
        findLexSmallestString("somestring", 0, 9);
    }
}