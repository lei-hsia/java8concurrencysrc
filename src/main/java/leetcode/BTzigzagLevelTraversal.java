package leetcode;

import java.util.*;

/* binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7

     [
      [3],
      [20,9],
      [15,7]
    ]
* */
public class BTzigzagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < count; ++i) {
                TreeNode cur = q.poll();
                if (flag) { // 第一次完flag变为true，所以下次来的时候应该是反过来加入到list
                    list.add(0, cur.val);
                } else list.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(list);
            flag = flag ? false : true;
        }
        return res;
    }
}
