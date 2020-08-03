package leetcode.binarysearch;

// 直接遍历每次乘x会超时，二分x每次减半，而res直接乘x的平方 如果x是偶数，否则还需要再多乘个x
public class Powerxn50 {
    public double myPow(double x, int n) {
        double res = 1;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n > 0 ? res : 1/res;
    }
}
