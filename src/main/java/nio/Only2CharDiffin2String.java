package nio;

/*
*   给定两个字符串str1 str2，判断str1是否可以只通过交换2个字符转换成str2 
*   str1 = "abc" str2 = "acb" true
*    str1 = "abc" str2 = "cab" false
*
    * cdxay  cdyax 
    * cdbab cdbab 
    * cdxaye cdyaxf 
    * cdbabe cdbabe
* */
public class Only2CharDiffin2String {
    public boolean twoCharEx(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        if (s1.length() == 0 && s2.length() == 0) return true;
        if (s1.length() != s2.length()) return false;

        int len = s1.length();

        int count = 0, idx1 = 0, idx2 = 0;
        for (int i = 0; i < len; ++i) {
            if (s1.charAt(i) != s2.charAt(i) && count == 0) {
                count = 1;
                idx1 = i;
            }
            if (s1.charAt(i) != s2.charAt(i) && count == 1) {
                count = 2;
                idx2 = i;
            } else if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        int sum = (s1.charAt(idx1) - s2.charAt(idx1)) + (s1.charAt(idx2) - s2.charAt(idx2));

        if (count == 0 && idx1 == 0 && idx2 == 0) return true;
        if (count == 2 && sum == 0) return true;

        return false;
    }
}