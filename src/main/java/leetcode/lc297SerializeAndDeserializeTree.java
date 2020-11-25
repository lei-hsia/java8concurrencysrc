package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class lc297SerializeAndDeserializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return hserialize(root, "");
    }

    public String hserialize(TreeNode root, String str) {
        if (root == null) str += "null,";
        else {
            str += str.valueOf(root.val) + ",";
            str = hserialize(root.left, str);
            str = hserialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        List<String> list = new LinkedList(Arrays.asList(dataArr));
        return hdeserialize(list);
    }

    public TreeNode hdeserialize(List<String> l) {
        if (l.get(0).equals("null")){
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = hdeserialize(l);
        root.right = hdeserialize(l);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));