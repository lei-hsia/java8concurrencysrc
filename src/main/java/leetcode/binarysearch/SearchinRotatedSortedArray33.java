package leetcode.binarysearch;

public class SearchinRotatedSortedArray33 {
    // nums[mid]<nums[right]:右半边是sorted的，nums[mid]>nums[right]:左半边是有序的
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid -1;
            } else {  // nums[mid] > target
                if (nums[mid] > target && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}
