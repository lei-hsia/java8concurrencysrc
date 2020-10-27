package leetcode.recursion;

/*
*   Imagine the recursion method as a black box which does the reverse job.
*   Divide and conquer, think how this problem would go to sub problems.
*
*   Main function: call helper
*
*       helper:
*           1. end condition: when to exit
*           2. do what should be done each round
*           3. call self recursively
* */
public class ReverseStringDC {
    public void reverseString(char[] s) {
        helper(0, s.length-1, s);
    }

    public static void helper(int start, int end, char[] s) {
        if (start >= end)
            return;

        // do what you would do each step recursively
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;

        // recurse
        helper(start+1, end-1, s);
    }
}
