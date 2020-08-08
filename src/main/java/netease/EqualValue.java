package netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EqualValue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // number of batches
        int numBatch = in.nextInt();
        List<Integer> res = new ArrayList<>();

        // 对每一组: 从小到大排序；求和，看是不是偶数，如果是，从后往前累加看能不能得到整个数组和的一半，如果可以就不用丢;
        // 如果不行，从前往后遍历丢(从小到大丢),再判断是不是偶数，如果是偶数就从后往前加，重复 (从后往前:因为这样greedy:快)

        // 因为每组都最多15个元素，所以可以这样直接暴力greedy计算

        for (int i = 0; i < numBatch; i++) {

            int num = in.nextInt(); // num个元素
            int[] arr = new int[num];
            int sum = 0;
            for (int j = 0; j < num; j++) {
                arr[j] = in.nextInt(); // 得到这组所有的数字
                sum += arr[j];
            }
            Arrays.sort(arr); //30 60 5 15 30 -->   5 15 30 30 60

            int count = 0; // 累积丢掉的和
            int index = 0; // 丢掉之后数之后，arr看作从index开始的数组
            int tmp = 0; // 从后往前加累加和
            int k = arr.length-1;

            while (index < arr.length) {
                if (sum % 2 == 0) {
                    while (tmp <= sum/2) {
                        tmp += arr[k--];
                        if (tmp == sum/2) {
                            res.add(0);
                            break;
                        }
                    }
                    // tmp > sum/2: 不可能相等了,  需要arr丢掉前面比较小的数，然后继续循环判断
                    count += arr[index];
                    sum -= arr[index++];
                } else {
                    while (index < arr.length) {
                        count += arr[index];
                        sum -= arr[index++];
                        if (sum % 2 == 0) {
                            while (tmp <= sum/2) {
                                tmp += arr[k--];
                                if (tmp == sum/2) {
                                    res.add(count); // 丢掉的累积和
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < numBatch; i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
