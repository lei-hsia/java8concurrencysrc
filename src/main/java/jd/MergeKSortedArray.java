package jd;

import java.util.List;

public class MergeKSortedArray {
    public static void main(String[] args) {
        /*
        *       1 8  3 2 8
        *       3 10 6 3 9
        *       5 15 7 9 10
        *
        *       1 2 3 3 4 5 5 ...
        * */

    }

    public static int[] cusSort(List<int[]> lists) {
        int total = 0, size = lists.size();
        int[] first = new int[size];
        for (int i = 0; i < size; i++) {
            first[i] = lists.get(i)[0];
        }

        int[] res= new int[total];
        res[0]  = lists.get(0)[0];
        int k = 0; // res index
        int[] pointers = new int[size]; //
        pointers[0] = 1;

        int len = 0, col = 0; // col: 横向；len: 纵向
        while (col < size) {
            if (lists.get(0)[pointers[len]] < lists.get(col)[pointers[col]]) {
                res[k++] = lists.get(0)[pointers[len]];
                len++;

            }
            else {
                res[k++] = lists.get(col)[pointers[col]];
                col++;
            }
        }
        for (int i = 0; i < size; i++) {
            if (lists.get(0)[pointers[len]] < lists.get(i)[pointers[0]]) {
                res[k++] = lists.get(0)[pointers[len]];
                len++;
                pointers[i]++;
            } else {

            }
        }

        // return res;
        return res;
    }
}
