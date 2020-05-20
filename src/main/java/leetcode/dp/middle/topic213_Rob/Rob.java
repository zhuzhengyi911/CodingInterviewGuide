package leetcode.dp.middle.topic213_Rob;

import java.util.HashMap;

/**
 * @program: CodingInterviewGuide
 * @description: 213. 打家劫舍 II
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 12:34
 * <p>
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/house-robber-ii/solution/tong-yong-si-lu-tuan-mie-da-jia-jie-she-wen-ti-by-/
 **/

public class Rob {


    /**
     * 暴力
     *
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return process1(nums, false, 0);
    }


    public static int process1(int[] nums, boolean first, int index) {
        if (index == 0) {
            return Math.max(nums[index] + process1(nums, true, index + 2), process1(nums, false, index + 1));
        }

        if (index == nums.length - 1) {

            if (first) {
                return 0;
            } else {
                return nums[nums.length - 1];
            }

        } else if (index > nums.length - 1) {
            return 0;
        }

        return Math.max(nums[index] + process1(nums, first, index + 2), process1(nums, first, index + 1));
    }


    /**
     * 记忆法(不是好方法)
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        return process2(nums, map, false, 0);
    }


    public static int process2(int[] nums, HashMap<String, Integer> map, boolean first, int index) {
        if (index == 0) {
            return Math.max(nums[index] + process2(nums, map, true, index + 2), process2(nums, map, false, index + 1));
        }

        if (index == nums.length - 1) {

            if (first) {
                return 0;
            } else {
                return nums[nums.length - 1];
            }

        } else if (index > nums.length - 1) {
            return 0;
        }

        String key = first + "_" + index;
        int result;
        if (map.containsKey(key)) {
            result = map.get(key);
        } else {

            result = Math.max(nums[index] + process2(nums, map, first, index + 2), process2(nums, map, first, index + 1));
            map.put(key, result);
        }
        return result;
    }


    /**
     *
     * DP
     *
     * 分成两段考虑
     *
     * @param nums
     * @return
     */
    public static int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }else if (nums.length == 1){
            return nums[0];
        }

        int c1 = process3(nums, 0, nums.length - 2);
        int c2 = process3(nums, 1, nums.length - 1);

        return Math.max(c1, c2);
    }


    public static int process3(int[] nums, int start, int end) {
        if (end - start == 0) {
            return nums[start];
        }

        int n = end - start + 1;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = nums[end];

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1],dp[i + 2] + nums[start + i] );
        }

        return dp[0];
    }



    public static int rob4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }else if (nums.length == 1){
            return nums[0];
        }

        int c1 = process4(nums, 0, nums.length - 2);
        int c2 = process4(nums, 1, nums.length - 1);

        return Math.max(c1, c2);
    }

    public static int process4(int[] nums, int start, int end) {
        if (end - start == 0) {
            return nums[start];
        }

        int pre2 = 0;
        int pre1 = nums[end];
        int current;
        for (int i = end - 1; i >= start; i--) {
            current = Math.max(pre1, nums[i] + pre2);

            pre2 = pre1;
            pre1 = current;

        }
        return pre1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
//        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob1(nums));
        System.out.println(rob2(nums));
        System.out.println(rob3(nums));
        System.out.println(rob4(nums));

    }


}
