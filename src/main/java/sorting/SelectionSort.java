package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionsort(int[] arr) {
        int tmp = 0, minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            // 交换当前数和minIndex对应的数
            tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 8, 11, 15, 43, 99, 21, 1};
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
