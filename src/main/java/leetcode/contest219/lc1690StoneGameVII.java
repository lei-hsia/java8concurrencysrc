package leetcode.contest219;

public class lc1690StoneGameVII {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        int[] cum = new int[n+1];

        for(int i = 0;i  < n;i++){
            cum[i+1] = cum[i] + stones[i];
        }

        for(int len = 1;len <= n;len++){
            for(int i = 0;i+len-1 < n;i++){
                int j = i+len-1;
                if(len == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.max(cum[j+1] - cum[i+1] - dp[i+1][j], cum[j] - cum[i] - dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
