package leetcode.dp.easy.topic746_MinCostClimbingStairs;

/**
 * @program: CodingInterviewGuide
 * @description: 746. 使用最小花费爬楼梯
 * @author: Zhu Zheng-yi
 * @create: 2020-05-08 18:41
 **/

public class MinCostClimbingStairs {

    /**
     * DP
     *
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs1(int[] cost) {
        if (cost.length == 0){
            return 0;
        }else if (cost.length == 1){
            return cost[0];
        }

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2 ; i < cost.length;i++){
            dp[i] = cost[i] + Math.min(dp[i -1],dp[i-2] );
        }
        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }

    /**
     * DP(压缩)
     *
     *
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs2(int[] cost) {
        if (cost.length == 0){
            return 0;
        }else if (cost.length == 1){
            return cost[0];
        }

        int pre1 = cost[1];
        int pre2 = cost[0];
        int current;

        for (int i = 2;i< cost.length ;i++){
            current = cost[i] + Math.min(pre1, pre2);
            pre2 = pre1;
            pre1 = current;
        }

        return Math.min(pre1,pre2);
    }






    public static void main(String[] args) {
//        int[] cost = new int[]{0,0,0,1};
        int[] cost = new int[]{1};
//        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};

        System.out.println(minCostClimbingStairs2(cost));


    }


}
