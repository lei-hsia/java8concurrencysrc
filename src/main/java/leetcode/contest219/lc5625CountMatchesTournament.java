package leetcode.contest219;

public class lc5625CountMatchesTournament {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n != 1) {
            res += n/2;
            n = (n % 2 == 0) ? n/2 : (n+1)/2;
        }
        return res;
    }
}