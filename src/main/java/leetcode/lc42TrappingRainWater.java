package leetcode;

public class lc42TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0, right = height.length - 1, res = 0;
        int maxL = height[left], maxR = height[right];
        while (left < right) {
            if (maxL < maxR) {
                res += Math.max(0, maxL - height[left]);
                maxL = Math.max(maxL, height[++left]);
            } else {
                res += Math.max(0, maxR - height[right]);
                maxR = Math.max(maxR, height[--right]);
            }
        }
        return res;
    }
}