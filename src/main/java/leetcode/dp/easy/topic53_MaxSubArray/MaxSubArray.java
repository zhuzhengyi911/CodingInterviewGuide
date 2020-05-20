package leetcode.dp.easy.topic53_MaxSubArray;


/**
 * 53. 最大子序和
 */

public class MaxSubArray {


    /**
     * 暴力
     *
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length;i++){
            for (int  j = i ; j < nums.length;j++){
                int sum = 0;
                for (int k = i ; k <= j ; k++){
                    sum += nums[k];
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    /**
     * dp方法
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 思路：dp[i] = max(dp[i-1]+nums[i],nums[i])
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            dp[i] = Math.max(dp[i - 1] + nums[i] , nums[i]);
        }

        int max = dp[0];
        for (int i = 1 ; i < dp.length;i++){
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * dp方法，空间改进
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1;i < nums.length;i++){
            pre = Math.max(pre + nums[i],nums[i]);
            max = Math.max(max,pre);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(nums));

    }
}
