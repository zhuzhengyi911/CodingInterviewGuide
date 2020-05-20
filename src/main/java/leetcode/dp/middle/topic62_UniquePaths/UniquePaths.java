package leetcode.dp.middle.topic62_UniquePaths;

/**
 * @program: CodingInterviewGuide
 * @description: 62. 不同路径
 * @author: Zhu Zheng-yi
 * @create: 2020-05-08 20:51
 **/

public class UniquePaths {


    /**
     * DP
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0){
            return 0;
        }

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


    /**
     * DP(压缩)
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0){
            return 0;
        }

        int[] preLine = new int[n];

        for (int j = 0; j < n ;j++){
            preLine[j] = 1;
        }

        for (int i = 1; i < m ; i++){
            int right = 1;
            for (int j = 1;j < n;j++){
                preLine[j] = right + preLine[j];
                right = preLine[j];
            }
        }

        return preLine[n -1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths1(7, 3));
        System.out.println(uniquePaths2(7, 3));
    }

}
