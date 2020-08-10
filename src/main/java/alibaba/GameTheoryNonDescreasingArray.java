package alibaba;

import java.util.Scanner;

/* 最后一个数的个数: 奇数: 1st win;
                  偶数:
                     倒数第二个数个数:
                         奇数: 1st win
                         偶数: 2nd win
*/

public class GameTheoryNonDescreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // #res

        for (int i = 0; i < n; ++i) {
            int num = sc.nextInt();
            String str = sc.nextLine();
            String[] strings = str.split(" ");
            int[] arr = new int[strings.length];
            for (int j = 0; j < strings.length; j++) {
                arr[j] = Integer.parseInt(strings[j]);
            }
            // 2 2 3 3 6
            int count1st = 0, count2nd = 0;
            int largest = arr[arr.length-1], secondLargest = 0;

            for (int j = arr.length-1; j >=0 ; j++) {
                if (arr[j] == largest) {
                    count1st++;
                    continue;
                }
                secondLargest = arr[j];  // 2nd largest
                if (arr[j] == secondLargest) {
                    count2nd++;
                    continue;
                }
                break;
            }

            if (count1st % 2 == 0 && count2nd %2 == 0) {
                System.out.println("NIUMEI");
            } else {
                System.out.println("NIUNIU");
            }
        }
    }
}
