package leetcode.contest219;

public class lc1689PartitionMinDecBinaryNum {
    public int minPartitions(String n) {
        int max = 0;
        char[] na = n.toCharArray();
        for (char c : na) {
            max = Math.max(max, c - '0');
        }
        return max;
    }
}
