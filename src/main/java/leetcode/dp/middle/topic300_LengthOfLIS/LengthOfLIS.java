package leetcode.dp.middle.topic300_LengthOfLIS;

/**
 * @program: CodingInterviewGuide
 * @description: 300. 最长上升子序列
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 19:11
 **/

public class LengthOfLIS {


    /**
     * DP
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }


    /**
     *
     * 二分查找
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        int[] ends = new int[nums.length];
        int end = 0;
        ends[0] = nums[0];

        int index;

        for (int i = 1; i < nums.length; i++) {
            printEnds(ends,end);
            index = search(ends, nums[i],end);
            System.out.println("index:"+index + " end:"+end);

            if (index > end && ends[end] <= nums[i]){
                end++;
            }
            ends[index] = nums[i];
        }

        return end + 1;
    }


    public static void printEnds(int[] ends,int end){
        for (int i = 0; i <= end ;i++){
            System.out.print(ends[i] + " ");
        }
        System.out.println();
    }

    public static int search(int[] nums, int target, int end) {
        int r = 0;
        int l = end;
        int m;

        while (r <= l) {
            m = r + (l - r) / 2;
            if (nums[m] < target){
                r = m + 1;
            }else {
                l = m - 1;
            }
        }
        return l + 1;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = new int[]{3,5,6,2,5,4,19,5,6,7,12};
//        int[] nums = new int[]{4,10,4,3,8,9};
        int[] nums = new int[]{-2,-1};
        System.out.println(lengthOfLIS1(nums));
        System.out.println(lengthOfLIS2(nums));


//        int[] a = new int[]{2,5,6};
//        System.out.println(search(a,6 ,2 ));


    }


}
