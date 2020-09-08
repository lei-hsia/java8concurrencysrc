package nvidia;

public class RegexDemo {
    // https://www.cnblogs.com/zhuyeshen/p/11038943.html
    // 正则匹配: 默认是贪婪模式；在量词后面直接加上一个问号？就是非贪婪模式。
    public static void main(String[] args) {
        String string = "北京市（海淀区）（朝阳区）（西城区）";
        String[] res = string.split(".*?(?=\\()");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
