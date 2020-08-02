package leetcode.binarysearch;

public class SearchinRotatedSortedArrayII81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                if (nums[mid] > target && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            } else { // nums[mid]==nums[right]: e.g. [1,1,3,1]: 和最右边对比,相等就收缩最右边,直到不等:得到右边段的max值
                right--;
            }
        }
        return false;
    }
}
