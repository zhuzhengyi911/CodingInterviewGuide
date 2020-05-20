package leetcode.dp.middle.topic221_MaximalSquare;

/**
 * @program: CodingInterviewGuide
 * @description: 221. 最大正方形
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 13:36
 **/

public class MaximalSquare {

    public static int maximalSquare1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = 0;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '0'){
                dp[0][j] = 0;
            }else {
                dp[0][j] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == '0'){
                dp[i][0] = 0;
            }else {
                dp[i][0] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }


    public static void main(String[] args) {
//        char[][] matrix = new char[][]{
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
//        };


        char[][] matrix = new char[][]{
                {'1', '0'}
        };

//        char[][] matrix = new char[][]{
//                {'0'},
//                {'1'}
//        };
        System.out.println(maximalSquare1(matrix));


    }


}
