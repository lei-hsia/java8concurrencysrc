package leetcode.dp;

/* greedy */
public class BestTimetoBuySellstock2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int i = 0, buy = 0, sell = 0, profit = 0, n = prices.length - 1;
        while (i < n) {

            while (i < n && prices[i+1] <= prices[i]) ++i;
            buy = prices[i];

            while (i < n && prices[i+1] > prices[i]) ++i;
            sell = prices[i];

            profit += (sell - buy);
        }

        return profit;
    }
}
