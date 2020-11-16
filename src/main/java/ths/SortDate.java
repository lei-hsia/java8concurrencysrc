package ths;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortDate {
    public static void main(String[] args) {
        customizedSort(new String[]{"2015-12-12", "2014-09-01"});
    }

    public static void customizedSort(String[] dates) {
        int n = dates.length;
        int[][] numDates = new int[n][3];
        HashMap<int[], String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] yearMonDay = dates[i].split("-");
            numDates[i][0] = Integer.parseInt(yearMonDay[0]);
            numDates[i][1] = Integer.parseInt(yearMonDay[1]);
            numDates[i][2] = Integer.parseInt(yearMonDay[2]);
            map.put(numDates[i], yearMonDay[i]);
        }

        Arrays.sort(numDates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                else if (o1[1] != o2[1]) return o1[1] - o2[1];
                else return o1[2] - o2[2];
            }
        });

        for (int[] numDate : numDates) {
            System.out.println(map.get(numDate));
        }

    }
}
