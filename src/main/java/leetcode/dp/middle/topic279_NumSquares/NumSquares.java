package leetcode.dp.middle.topic279_NumSquares;

/**
 * @program: CodingInterviewGuide
 * @description: 279. 完全平方数
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 18:15
 **/

public class NumSquares {


    /**
     *
     * DP
     *
     * f(12) = min{f(12 - 1 * 1),f(12 - 2 * 2),f(12 - 3 * 3)} + 1
     *
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int k = 1;
        while (k * k <= n) {
            k++;
        }
        k--;

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 2; j <= k && i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j]);
            }
            dp[i]++;
        }

        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(numSquares(4));
    }


}
