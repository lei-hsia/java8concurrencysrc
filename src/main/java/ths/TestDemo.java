package ths;

public class TestDemo {
    static int getValue(int i) {
        int res = 0;
        switch (i){
            case 1:res = res + i;
            case 2:res = res + i*2;
            case 4:res = res + i*3;
            case 8:res = res + i*4;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getValue(2));
    }
}
