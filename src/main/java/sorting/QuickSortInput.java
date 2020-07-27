package sorting;

import java.util.Scanner;

public class QuickSortInput {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String str = in.nextLine();
        String[] strings = str.split(",");
        int[] arr = new int[strings.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        //int[] arr = {2,4,5,6,8,11,15,43,99,21,1};
        quicksort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quicksort(int[] arr, int left, int right) {
        int i = left, j = right;
        int pivot = arr[(i + j) / 2];

        while (i <= j) {

            while (arr[i] < pivot)  ++i;
            while (arr[j] > pivot) --j;

            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                ++i; --j;
            }
        }

        // i > j
        if (left < j) quicksort(arr, left, j); // left < j: j一直减小，最后小于left了
        if (right > i) quicksort(arr, i, right);
    }

}
