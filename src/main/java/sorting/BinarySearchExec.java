package sorting;


public class  BinarySearchExec {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println(binarysearch_middle(arr, 2));
        System.out.println(binarysearch_leftbound(arr, 2));
        System.out.println(binarysearch_rightbound(arr, 2));
    }

    // 都是[left, right), 所以边界赋值时候为left = mid+1, right = mid (left已经检查过了)
    public static int binarysearch_middle(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (target == arr[mid]) return mid;
            else if (target < arr[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static int binarysearch_leftbound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (target == arr[mid]) right = mid;
            else if (target < arr[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static int binarysearch_rightbound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (target == arr[mid]) left = mid + 1;
            else if (target < arr[mid]) right = mid;
            else left = mid + 1;
        }
        return left - 1; // left==right:但是right是达不到的
    }
}
