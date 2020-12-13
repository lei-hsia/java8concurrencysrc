package leetcode.contest219;

import java.util.Arrays;

public class lc5245MaxHeight {
    public int maxHeight(int[][] nums) {
        for (int[] n : nums) {
            Arrays.sort(n);
        }

        Arrays.sort(nums, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else if (a[1] != b[1]) return a[1] - b[1];
            else return a[2] - b[2];
        });

        int n = nums.length, i, j, res = 0;
        int[] dp = new int[n+1];

        for (i = 0; i < n; i++) {
            dp[i] = nums[i][2];
            res = Math.max(dp[i], res);
        }
        // dp表示累加高度，因为可能出现中间跳跃选择cube而不知道跳过了哪些，所以需要dp保存到目前为止的累计高度
        for (i = 1; i < n; ++i) {
            for (j = 0; j < i; ++j) {
                if (nums[i][0]>=nums[j][0] && nums[i][1]>=nums[j][1] && nums[i][2]>=nums[j][2]){
                    dp[i] = Math.max(dp[i], dp[j]+nums[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}