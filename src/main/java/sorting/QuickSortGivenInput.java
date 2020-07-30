package sorting;

public class QuickSortGivenInput {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 8, 11, 15, 43, 99, 21, 1};
        quicksort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
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
                ++i; --j;
            }
        }

        if (left < j)   quicksort(arr, left, j);
        if (i < right) quicksort(arr, i, right);
    }
}
