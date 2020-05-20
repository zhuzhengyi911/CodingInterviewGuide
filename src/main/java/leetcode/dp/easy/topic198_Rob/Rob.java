package leetcode.dp.easy.topic198_Rob;

import java.util.HashMap;

public class Rob {


    /**
     * 暴力
     * <p>
     * 时间复杂度: O(2^n)
     * 空间复杂度: O(n)
     *
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return process1(nums, 0);
    }


    public static int process1(int[] nums, int index) {
        if (index == nums.length - 1) {
            return nums[nums.length - 1];
        } else if (index > nums.length - 1) {
            return 0;
        }
        return Math.max(nums[index] + process1(nums, index + 2), process1(nums, index + 1));
    }


    /**
     * 记忆法
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        return process2(nums, map, 0);
    }

    public static int process2(int[] nums, HashMap<Integer, Integer> map, int index) {
        if (index == nums.length - 1) {
            return nums[nums.length - 1];
        } else if (index > nums.length - 1) {
            return 0;
        }

        int result;
        if (map.containsKey(index)) {
            result = map.get(index);
        } else {
            result = Math.max(nums[index] + process2(nums, map, index + 2), process2(nums, map, index + 1));
            map.put(index, result);
        }
        return result;
    }


    /**
     * DP
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     *
     * @param nums
     * @return
     */
    public static int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        int n = nums.length;
        dp[n] = 0;
        dp[n - 1] = nums[n - 1];

        for (int i = n - 2;i >= 0;i--){
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }


    /**
     * DP(压缩)
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     *
     * @param nums
     * @return
     */
    public static int rob4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int pre2 = 0;
        int pre1 = nums[n - 1];
        int current = pre1;

        for (int i = n - 2;i >= 0;i--){
            current = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = current;
        }
        return current;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 9, 3, 1};


        int[] nums = new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};


//        int[] nums = new int[]{1};
//        System.out.println(rob1(nums));
        System.out.println(rob2(nums));
        System.out.println(rob3(nums));
        System.out.println(rob4(nums));
    }


}
