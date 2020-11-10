package hiretual;

import java.util.Scanner;

public class UpAllBeforeDown {
    // uduuudu  dd: 2
    // uddddddu  d: 2
    /*
        traverse from back to front: find limit of (...u ddddd..), the back are all d; lock this index of 'u' as anchor;
        then, traverse from front to anchor; count #u and #d; if #u > #d; flip all d to u; otherwise flip all u to d
        to make all array as d, i.e. pure-d array. I.e. take the smaller value

        Usage: please input your array. Only u or d are okay
    * */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] arr = s.toCharArray();
        int res = minNumToFlip(arr);
        System.out.println(res);
    }

    public static int minNumToFlip(char[] arr) {
        // char[] arr := uduuududd
        int n = arr.length, anchor = n;
        for (int i = n-1; i >= 0; i--) {
            if (arr[i] == 'u'){
                anchor = i;
                break;
            }
        }
        System.out.println("anchor: "+anchor);
        int numU = 0, numD = 0; //
        for (int i = 0; i <= anchor; i++) {
            if (arr[i]=='u') numU++;
            else numD++;
        }
        return Math.min(numD, numU);
    }
}
