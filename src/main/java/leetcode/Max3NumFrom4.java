package leetcode;
/*
*       5 1 4 2
* */
public class Max3NumFrom4 {
    public static void main(String[] args) {
        int[] nums = {5,1 ,4, 2};
        System.out.println(maxVal(nums));
    }

    public static int maxVal(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; ++i) {
            sb.append(nums[i]);
        }
        String str = sb.toString();

        int n = nums.length;
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = Integer.parseInt(str.substring(0,i)+str.substring(i+1, 4));
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            //System.out.println(output[i]+"---");
            res = Math.max(res, output[i]);
        }
        return res;
    }
}
