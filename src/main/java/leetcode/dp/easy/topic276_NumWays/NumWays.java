package leetcode.dp.easy.topic276_NumWays;

/**
 * @program: CodingInterviewGuide
 * @description: 276. 栅栏涂色
 * @author: Zhu Zheng-yi
 * @create: 2020-05-08 11:15
 **/

public class NumWays {


    /**
     * DP
     * @param n
     * @param k
     * @return
     */
    public static int numWays1(int n, int k) {
        if (n == 0 || k == 0){
            return 0;
        }else if (n == 1){
            return k;
        }

        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k*k;

        for (int i = 2;i < n;i++){
            dp[i] = dp[i - 2] * (k - 1) + dp[i - 1] * (k - 1);
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {
        /**
         * n : 柱子
         * k : 颜色数
         */
        int n = 3;
        int k = 2;
        System.out.println(numWays1(n, k));

    }


}
