package leetcode.contest218;

import java.util.Arrays;

public class lc1679TwoSumRepeatedPair {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if (k < nums[0]) return 0;

        //1. all clear;
        // int len = nums.length, sum = 0;
        // for (int n : nums) sum += n;
        // if (len % 2 == 0 && sum/k == (len/2)) return len/2;
        int len = nums.length;
        // 2. two sum: max
        int left = 0, right = len-1;

        int count = 0;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                count++; left++; right--;
            } else if (nums[left] + nums[right] > k) right--;
            else left++;
        }

        return count;
    }
}