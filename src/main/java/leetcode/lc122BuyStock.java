package leetcode;

public class lc122BuyStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length - 1, res = 0, i = 0, buy = 0, sell = 0;

        while (i < n) {
            while (i < n && prices[i+1] <= prices[i]) i++;
            buy = prices[i];
            while (i < n && prices[i+1] > prices[i]) i++;
            sell = prices[i];

            res += (sell - buy);
        }
        return res;
    }
}