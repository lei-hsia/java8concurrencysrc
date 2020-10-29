package leetcode.lc215;


public class KthLargestElementUnsortedArray {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = find(nums, left, right);
            if (pos == k - 1) return nums[pos];
            if (pos > k - 1) right = pos - 1;
            else left = pos + 1;
        }
    }

    public static int find(int[] nums, int left, int right) {
        // 对i-j进行quicksort，pivot为第一个元素, 最后交换出循环的数和pivot
        int pivot = nums[left], i = left+1, j = right;
        while (i <= j) {

            if (nums[i] < pivot && nums[j] > pivot) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++i; --j;
            }
            if (nums[i] >= pivot) ++i;
            if (nums[j] <= pivot) --j;
        }
        int tmp = nums[left];
        nums[left] = nums[j];
        nums[j] = tmp;
        return j;
    }
}
