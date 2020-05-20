package leetcode.dp.middle.topic63_UniquePathsWithObstacles;

/**
 * @program: CodingInterviewGuide
 * @description: 63. 不同路径 II
 * @author: Zhu Zheng-yi
 * @create: 2020-05-08 21:12
 **/

public class UniquePathsWithObstacles {


    /**
     * DP
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }


        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }


    /**
     * DP(压缩)
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1){
            return 0;
        }

        int[] preLine = new int[obstacleGrid[0].length];

        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 0) {
                preLine[j] = 1;
            } else {
                break;
            }
        }

        boolean flag = false;
        for (int i = 1; i < obstacleGrid.length; i++) {
            int right;
            if (obstacleGrid[i][0] == 1 || flag){
                right = 0;
                flag =true;
            }else {
                right = 1;
            }

            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    preLine[j] = 0;
                } else {
                    preLine[j] = preLine[j] + right;
                }
                right = preLine[j];
            }
        }

        return preLine[preLine.length - 1];
    }


    public static void main(String[] args) {
//        int[][] obstacleGrid = new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };

        int[][] obstacleGrid = new int[][]{
                {1},
                {0}
        };

//        int[][] obstacleGrid = new int[][]{
//                {0},
//                {1}
//        };


        System.out.println(uniquePathsWithObstacles1(obstacleGrid));
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));
    }


}
