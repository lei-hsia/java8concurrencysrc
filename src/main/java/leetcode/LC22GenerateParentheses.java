package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        generate(n, n, "", res);
        return res;
    }

    // left: remain #(   right: remain #)
    public void generate(int left, int right, String tmp, List<String> res) {
        if (left > right) return; // left用的更多，应该剩的更少，如果剩的多就不对，return
        if (left == 0 && right == 0) res.add(tmp);
        else {
            if (left > 0) generate(left - 1, right, tmp + "(", res);
            if (right > 0) generate(left, right - 1, tmp + ")", res);
        }
    }
}