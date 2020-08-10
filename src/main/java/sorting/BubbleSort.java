package sorting;

/* 两两比较并交换: 所以叫bubble sort */
public class BubbleSort {

    public static void bubblesort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) { // j < len - 1 - i: 尾部逐渐缩小，每次最后面的元素都往前移动一个
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 8, 11, 15, 43, 99, 21, 1};
        bubblesort(arr);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
