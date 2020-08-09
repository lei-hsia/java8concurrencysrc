package netease;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

public class STsmallestDictPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 题目是不是有问题？ 又没有说输出的每个数字不能不同，那么在第二行m个数前面补充(n-m)个1即可

        int n = in.nextInt();
        int m = in.nextInt();
        int[] res = new int[n]; // res

        // 先入先出，之后从前往后的顺序加入res
        Queue<Integer> q = new LinkedList<>();
        // 除了给的m个数，剩下的(n-m)个数应该都不等于这m个数，用set进行判断
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int k = in.nextInt();
            q.offer(k);
            set.add(k);
        }

        //int[] tmp = new int[n-m]; // 存放需要的剩下的(n-m)个数
        Queue<Integer> composite = new LinkedList<>(); // Queue比较方便
        for (int i = 1; ; i++) {
            if (!set.contains(i)) {
                composite.offer(i);
                //tmp[i-1] = i;
            }
            if (composite.size() == n-m) break;
            //if (tmp[tmp.length-1] != 0) break;

        }

        // 这里: Queue中是m个本来就有的数按顺序排放； tmp是(n-m)个数按从小到大排列
        for (int i = 0; i < n; i++) {
            if ( q.peek() < composite.peek()) {
                res[i] = q.poll();
            } else {
                res[i] = composite.poll();
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
