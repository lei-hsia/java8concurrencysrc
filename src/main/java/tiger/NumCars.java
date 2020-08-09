package tiger;

import java.util.*;


public class NumCars {
    /**
     * 返回最少需要多少辆车
     * @param trips int整型二维数组 二维int数组，用于表示一组乘客的行程信息，其中`trip[i]`表示第i组乘客，`trip[i][0]`表示第i组乘客的乘客数量，`trip[i][1]`表示上车站点，`trip[i][2]`表示下车站点。
     * @param capacity int整型 int类型，表示每辆车最多能承载多少名乘客
     * @return int整型
     */
    public int minCarCount (int[][] trips, int capacity) {
        // write code here

        /*   对trips排序: 自定义规则：按照trips中数组的第二个元素从小到大排序；
                e.g. [2, 1, 5]
                        1. [3, 2, 3]
                        2. [3, 2, 7]
                        3. [3, 7, 10]
        * */
        Arrays.sort(trips, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int i = 0; // i: 每段开头;
        while (i < trips.length) {
            int k = 1; //k: 这一段滑动指针
            // [2, 1, 5],[3, 2, 3] 5>3;  可以顺路
            while (trips[i][2] >= trips[i+k][2]) {
                trips[i][0] += trips[i+k][0];
                trips[i+k][0] = 0;
                ++k;
            }
            i += k; // 从新一段开始
        }

        // 全是每一段的，都不顺路， 遍历trips所有的值，都需要专门的car来
        int res = 0;
        for (int[] trip : trips) {
            res += Math.ceil(trip[0]);
        }

        return res;
    }
}
