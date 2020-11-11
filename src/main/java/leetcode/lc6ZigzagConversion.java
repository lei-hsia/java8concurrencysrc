package leetcode;

public class lc6ZigzagConversion {
    public String convert(String s, int numRows) {
        char[] ch = s.toCharArray();
        int len = s.length();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) sb[i] = new StringBuilder();

        int index = 0;
        while (index < len) {
            for (int i = 0; i < numRows && index < len; i++)
                sb[i].append(ch[index++]);
            for (int i = numRows - 2; i >= 1 && index < len; i--)
                sb[i].append(ch[index++]);
        }
        for (int i = 1; i < numRows; ++i)
            sb[0].append(sb[i]);
        return sb[0].toString();
    }
}
