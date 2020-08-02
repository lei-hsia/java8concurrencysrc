package leetcode.binarysearch;

// essential: left bound && right bound
public class FindFirstLastIndexSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) right = mid;
            else if (target < nums[mid]) right = mid;
            else left = mid + 1;
        }
        // left == right
        System.out.println(left);
        System.out.println(right);
        // nums[right] != target: left & right收缩到要找的数的位置，但是这个数并不一定存在
        // e.g. [5,7,7,8,8,10]  6
        if (right == nums.length || nums[right] != target) return res;
        res[0] = left;

        // right bound
        left = 0; right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) left = mid + 1;
            else if (target > nums[mid]) left = mid + 1;
            else right = mid;
        }
        res[1] = left - 1; // 注意这里

        return res;
    }
}
