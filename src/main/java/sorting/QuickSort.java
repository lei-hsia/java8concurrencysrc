package sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 64, 3, 21, 4, 2, 9, 42, 99, 3};
        quicksort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length-1; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quicksort(int[] arr, int left, int right) {
        int i = left, j = right;
        int pivot = arr[(i + j) / 2];

        while (i <= j) {

            while (arr[i] < pivot) ++i;
            while (arr[j] > pivot) --j;

            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                ++i;
                --j;
            }
        }

        // i > j
        if (left < j) quicksort(arr, left, j);
        if (i < right) quicksort(arr, i, right);
    }
}
