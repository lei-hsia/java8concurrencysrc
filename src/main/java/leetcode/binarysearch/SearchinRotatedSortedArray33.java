package leetcode.binarysearch;

public class SearchinRotatedSortedArray33 {
    // 实际上是根据nums[mid]和nums[right]的大小，判断应该去那一边搜索: 总是要去sorted的那一边;
    // 根据mid位置的数的大小，包含这个的是sorted，另一边是rotated
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
