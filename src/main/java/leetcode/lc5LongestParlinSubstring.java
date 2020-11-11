package leetcode;

public class lc5LongestParlinSubstring {
    private int begin, max; // starting index; length

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        for (int i = 0; i < n-1; ++i) {
            diffuse(s, i, i); // odd length
            diffuse(s, i, i+1); // even
        }
        return s.substring(begin, begin+max);
    }

    public void diffuse(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--; k++;
        }
        if (max < k-j-1) {
            max = k-j-1;
            begin = j+1;
        }
        // max = Math.max(max, k-j-1);
        begin = j + 1;
    }
}