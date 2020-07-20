package sorting;

import java.util.HashMap;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println(binarysearch_middle(arr, 2));
        System.out.println(binarysearch_middle_unequal(arr, 2));
        System.out.println(binarysearch_leftBound(arr, 2));
        System.out.println(binarysearch_rightBound(arr, 2));
    }

    // [left, right] 全为闭区间: 所以while中有等号，条件判断 left/right的更新都是不等: [left, mid-1], [mid+1, right]
    /* 缺陷:
        比如说给你有序数组 arr = [1,2,2,2,3]，target 为 2，此算法返回的索引是 2，没错。
        但是如果我想得到 target 的左侧边界，即索引 1，或者我想得到 target 的右侧边界，即索引 3，这样的话此算法是无法处理的。
    */
    public static int binarysearch_middle(int[] arr, int num) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == num) return mid;
            else if (num < arr[mid]) right = mid - 1; // target小了，往左边找
            else if (num > arr[mid]) left = mid + 1;
        }

        return -1; //包含了arr.length==0的情况
    }

    public static int binarysearch_middle_unequal(int[] arr, int num) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num == arr[mid]) return mid;
            else if (num < arr[mid]) right = mid; // 不可能是mid，right是达不到的，所以 right=mid
            else left = mid + 1;
        }
        return left;
    }

    // [left, right): 左闭右开: [left, mid-1], [mid, right]: 寻找左边界

    // leftBound: if (arr[mid] == num) right = mid;
    public static int binarysearch_leftBound(int[] arr, int num) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == num) right = mid; // 找到元素的时候，收缩上界right直到最左边; 注:都只有这一行不同!!
            else if (num < arr[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // right bound: if (arr[mid] == num) left = mid + 1;
    public static int binarysearch_rightBound(int[] arr, int num) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == num) left = mid + 1;
            else if (num < arr[mid]) right = mid;
            else left = mid  + 1;
        }
        return left - 1;
    }
}
