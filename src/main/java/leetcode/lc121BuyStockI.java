package leetcode;

public class lc121BuyStockI {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int res = 0, min = prices[0];
        for (int i = 1; i < n; ++i) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}
