package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC39CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        dfs(nums, target, res, new ArrayList(), 0);
        return res;
    }

    public void dfs(int[] nums, int target, List<List<Integer>> res, ArrayList<Integer> tmp, int index) {
        if (target < 0) return;
        if (target == 0) {
//            for (int k = 0; k < tmp.size(); k++) System.out.print(tmp.get(k)+"*");
//            System.out.println("---");
            res.add(new ArrayList(tmp));
        }
        else {
            for (int i = index; i < nums.length; ++i) {
                tmp.add(nums[i]);
//                for (int k = 0; k < tmp.size(); k++) System.out.print(tmp.get(k)+" ");
//                System.out.println();
                dfs(nums, target - nums[i], res, tmp, i);
                tmp.remove(tmp.size() - 1); // 加的时候总是那个⚓️点的index开始加，一番dfs之后index可能早就变了，但是总是remove最后一个元素
//                for (int k = 0; k < tmp.size(); k++) System.out.print(tmp.get(k)+"-");
//                System.out.println();
            }
        }
    }
}
/*
https://blog.csdn.net/x_iya/article/details/81260154

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

整个dfs过程
    2
    2 2
    2 2 2
    2 2 2 2
    2-2-2-
    2 2 2 3
    2-2-2-
    2 2 2 6
    2-2-2-
    2 2 2 7
    2-2-2-
    2-2-
    2 2 3
    2*2*3*---
    2-2-
    2 2 6
    2-2-
    2 2 7
    2-2-
    2-
    2 3
    2 3 3
    2-3-
    2 3 6
    2-3-
    2 3 7
    2-3-
    2-
    2 6
    2-
    2 7
    2-

    3
    3 3
    3 3 3
    3-3-
    3 3 6
    3-3-
    3 3 7
    3-3-
    3-
    3 6
    3-
    3 7
    3-

    6
    6 6
    6-
    6 7
    6-

    7
    7*---
* */