package leetcode;

/*  Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
* */
public class KthLargestElementinArray215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        // 递归调用在主函数中，每次调用find方法只返回一次找到的index
        while (true) {
            int pos = find(nums, left, right);
            if (pos == k-1) return nums[pos];  //res
            if (pos > k-1) right = pos-1;
            else left = pos+1;
        }
    }

    public static int find(int[] nums, int left, int right) {
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
