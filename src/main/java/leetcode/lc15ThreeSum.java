package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 很好的题，遍历数组，每个index右边都是双指针 */
public class lc15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        int n = nums.length;
        if (n==0 || nums[0] >0 || nums[n-1] < 0) return res;

        for (int k = 0; k < n-2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k-1] == nums[k]) continue;
            int i = k+1, j = n-1;
            int target = -nums[k];
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    res.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (i < j && nums[i] == nums[i+1]) i++;
                    while (i < j && nums[j] == nums[j-1]) j--;
                    ++i; --j;
                } else {
                    if (nums[i] + nums[j] < target) ++i;
                    else --j;
                }
            }
        }
        return res;
    }
}