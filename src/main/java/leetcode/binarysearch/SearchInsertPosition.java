package leetcode.binarysearch;

// 本质上就是binarysearch; 元素找到就找到了，找不到left和right也会在需要插入的地方meet
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
