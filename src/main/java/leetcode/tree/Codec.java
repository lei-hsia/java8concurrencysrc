package leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*      You may serialize the following tree:

            1
           / \
          2   3
             / \
            4   5

        as "[1,2,3,null,null,4,5]"
* */
public class Codec {

    public String rserialize(TreeNode root, String str) {
        if (root == null) { // do not return
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ","; // 真正做事情的
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }


    // Decodes your encoded data to tree. 给一个数组，变成list再从中边拿边创建树，得到结果
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1= new TreeNode(3);
        root.left = left1;
        root.right = right1;
        left1.left = null;
        left1.right = null;
        right1.left = new TreeNode(4);
        right1.right = new TreeNode(5);


        Codec codec = new Codec();
        System.out.println(codec.serialize(root));

        // System.out.println(codec.deserialize("[1,2,3,null,null,4,5]"));
    }
}