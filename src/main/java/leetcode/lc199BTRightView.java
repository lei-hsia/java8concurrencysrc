package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc199BTRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList();
        List<Integer> list = new ArrayList();
        q.offer(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; ++i) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(list.get(list.size()-1));
        }
        return res;
    }
}
