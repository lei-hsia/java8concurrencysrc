package leetcode;

public class lc9ParlindromeInteger {
    public boolean isPalindrome(int x) {
        if (x < 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) return false;
        int rev  = 0, original = x;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x/10;
        }
        return original == rev;
    }
}