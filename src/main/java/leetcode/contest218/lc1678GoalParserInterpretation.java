package leetcode.contest218;

public class lc1678GoalParserInterpretation {
    public String interpret(String command) {
        if (command == null || command.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0, n = command.length();
        while (i < n) {
            if (command.charAt(i) == 'G') {
                sb.append("G"); ++i;
            } else if (command.substring(i, i+2).equals("()")) {
                sb.append("o"); i+=2;
            } else {
                sb.append("al"); i+=4;
            }
        }
        return sb.toString();
    }
}