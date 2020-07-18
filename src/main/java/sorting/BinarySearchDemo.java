package sorting;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println(binarysearch1(arr, 14));
    }

    // [left, right] 全为闭区间: 所以while中有等号，条件判断 left/right的更新都是不等: [left, mid-1], [mid+1, right]
    /* 缺陷:
        比如说给你有序数组 nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 2，没错。
        但是如果我想得到 target 的左侧边界，即索引 1，或者我想得到 target 的右侧边界，即索引 3，这样的话此算法是无法处理的。
    */
    public static int binarysearch1(int[] arr, int num) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == num) return mid;
            else if (num < arr[mid]) right = mid - 1; // target小了，往左边找
            else if (num > arr[mid]) left = mid + 1;
        }

        return -1;
    }
}
