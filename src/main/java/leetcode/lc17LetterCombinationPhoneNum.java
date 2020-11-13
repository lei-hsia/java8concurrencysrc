package leetcode;

import java.util.LinkedList;
import java.util.List;

public class lc17LetterCombinationPhoneNum {
    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList();
        if (digits.length() == 0) return res;
        res.add("");

        while (res.peek().length() != digits.length()) {
            String tmp = res.poll();
            String add = mapping[digits.charAt(tmp.length()) - '0'];
            for (char c: add.toCharArray()) {
                res.add(tmp + c);
            }
        }
        return res;
    }
}
