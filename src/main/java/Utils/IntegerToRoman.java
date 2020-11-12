package Utils;

public class IntegerToRoman {
    // integer to roman可以辗转减，roman to integer就只能一一对应:先放在一个map中
    public String intToRoman(int num) {
        int[] s1 = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] s2 = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res = "";

        for (int i = 0; i < s1.length; ++i) {
            while (num >= s1[i]) { // 等于都可以减
                num -= s1[i];
                res += s2[i];
            }
        }

        return res;
    }
}