package leetcode.binarysearch;

// https://leetcode.com/problems/divide-two-integers/description/

public class DivideTwoIntegers29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) // [−2^31,  2^31 − 1]
            return Integer.MAX_VALUE;

        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        long dvd = Math.abs((long) dividend), dvs = Math.abs((long) divisor);
        int res = 0;

        while (dvs <= dvd) { // tmp: varies each time; dvs: stays same
            long tmp = dvs, m = 1;
            while (dvs << 1 <= dvd) { // *2: exp; faster than minus; ~ binarysearch
                tmp <<= 1;
                m <<= 1;
            }
            dvd -= tmp;
            res += m;
        }

        return sign * res;
    }
}
