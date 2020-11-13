package leetcode;

import java.util.Stack;

public class LC20ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for (char c : s.toCharArray()) {
            switch(c) {
                case '(':
                case '[':
                case '{': st.push(c); break;
                case ')': if (st.empty() || st.peek() != '(') return false; else st.pop(); break;
                case ']': if (st.empty() || st.peek() != '[') return false; else st.pop(); break;
                case '}': if (st.empty() || st.peek() != '{') return false; else st.pop(); break;
            }
        }
        return st.empty() ? true : false;
    }
}
