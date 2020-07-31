package leetcode.dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount+1];
        if (coins.length == 0) return -1;
        f[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            f[i] = amount+1; // initialize when used
            for (int j = 0; j < coins.length; ++j) {
                if (i >= coins[j]) {
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }

        return f[amount] == amount+1 ? -1 : f[amount];
    }
}
