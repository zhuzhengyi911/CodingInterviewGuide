package leetcode.dp.middle.topic152_MaxProduct;

/**
 * @program: CodingInterviewGuide
 * @description: 152. 乘积最大子数组
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 10:53
 **/

public class MaxProduct {

    /**
     * DP1(不是好方法)
     * <p>
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     *
     * @param nums
     * @return
     */
    public static int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int product = 1;
            dp[i] = Integer.MIN_VALUE;
            for (int j = i; j >= 0; j--) {
                product *= nums[j];
                dp[i] = Math.max(dp[i], product);
            }
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }


    /**
     * DP
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public static int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int totalMax = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            totalMax = Math.max(totalMax, max);
        }

        return totalMax;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 3, -2, 4
        };

        System.out.println(maxProduct1(nums));
        System.out.println(maxProduct2(nums));
    }


}
