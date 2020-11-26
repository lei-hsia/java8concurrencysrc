package hiretual;

import java.util.LinkedList;
import java.util.Queue;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

       3
     /   \
    5     1
   / \   / \
  6   2 0   8
     / \
    7   4


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 */

public class BuildTreeLevelandLCA {

    public static void main(String[] args) {

        String input = "3,5,1,6,2,0,8,null,null,7,4";
        String[] str = input.split(",");

        TreeNode root = build(str);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode res = lca(p, q, root);
        System.out.println(res.val);

    }

    public static TreeNode build(String[] str) {
        Queue<TreeNode> q = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.add(root);

        TreeNode cur = null; // node from queue
        boolean addedLeft = false; // if added left child

        for(int i = 1; i < str.length; ++i) {
            TreeNode node = null;
            if (!str[i].equals("null")) {
                node = new TreeNode(Integer.parseInt(str[i]));
                q.offer(node);
            }
            if (!addedLeft) {
                cur = q.poll();
                cur.left = node;
                addedLeft = true;

            } else {
                cur.right = node;
                addedLeft = false;
            }
        }
        return root;
    }


    public static TreeNode lca(TreeNode p, TreeNode q, TreeNode root) {
        if (root == null || root == p || root == q) return root;

        TreeNode leftSub = lca(p, q, root.left);
        TreeNode rightSub = lca(p, q, root.right);

        if (leftSub != null && rightSub != null) return root;
        else if (leftSub != null) return leftSub;
        return rightSub;

    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/*
Your previous Plain Text content is preserved below:

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

       3
     /   \
    5     1
   / \   / \
  6   2 0   8
     / \
    7   4

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
 */


