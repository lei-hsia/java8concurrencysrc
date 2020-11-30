package leetcode;

public class lc1574ShortestSubarrayRemoveSortedArray {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0, n = arr.length;
        while (left + 1 < n && arr[left] <= arr[left+1]) left++;
        if (left == n-1) return 0;

        int right = n-1;
        while (right > left && arr[right-1] <= arr[right]) right--;
        if (right == 0) return 0;

        int res = Math.min(n - left -1, right);

        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[j] >= arr[i]) {
                res = Math.min(res, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}