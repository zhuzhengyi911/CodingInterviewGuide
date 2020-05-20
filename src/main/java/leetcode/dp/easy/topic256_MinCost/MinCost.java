package leetcode.dp.easy.topic256_MinCost;

import java.util.HashMap;

/**
 * @program: CodingInterviewGuide
 * @description: 256. 粉刷房子
 * @author: Zhu Zheng-yi
 * @create: 2020-05-08 10:08
 **/

public class MinCost {


    /**
     * 暴力方法
     * <p>
     * 时间复杂度:O(3^n)
     * 空间复杂度:O(n)
     *
     * @param costs
     * @return
     */
    public static int minCost1(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        return process1(costs, 0, -1);
    }

    public static int process1(int[][] costs, int house, int preColor) {
        if (house == costs.length) {
            return 0;
        }

        int cost = Integer.MAX_VALUE;
        for (int color = 0; color < costs[0].length; color++) {
            if (color != preColor) {
                cost = Math.min(cost, costs[house][color] + process1(costs, house + 1, color));
            }
        }

        return cost;
    }


    /**
     * 记忆法（不是好方法）
     *
     * @param costs
     * @return
     */
    public static int minCost2(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        return process2(costs, map, 0, -1);
    }

    public static int process2(int[][] costs, HashMap<String, Integer> map, int house, int preColor) {
        if (house == costs.length) {
            return 0;
        }

        int cost = Integer.MAX_VALUE;

        String key = String.valueOf(house) + "_" + String.valueOf(preColor);
        if (map.containsKey(key)) {
            cost = map.get(key);
        } else {
            for (int color = 0; color < costs[0].length; color++) {
                if (color != preColor) {
                    cost = Math.min(cost, costs[house][color] + process2(costs, map, house + 1, color));
                }
            }
            map.put(key, cost);
        }

        return cost;
    }


    /**
     * DP
     * <p>
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     *
     * @param costs
     * @return
     */
    public static int minCost3(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int m = costs.length;
        int n = costs[0].length;

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < m; i++) {

            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int result1 = costs[i][j] + dp[i - 1][(j + 1) % n];
                int result2 = costs[i][j] + dp[i - 1][(j + 2) % n];
                dp[i][j] = Math.min(dp[i][j], Math.min(result1, result2));
            }
        }

        int cost = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            cost = Math.min(cost, dp[m - 1][j]);
        }
        return cost;
    }


    /**
     * DP(压缩)
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param costs
     * @return
     */
    public static int minCost4(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int preR = costs[0][0];
        int preB = costs[0][1];
        int preG = costs[0][2];

        int currentR = preR;
        int currentB = preB;
        int currentG = preG;

        for (int i = 1; i < costs.length; i++) {
            currentR = Math.min(costs[i][0] + preB, costs[i][0] + preG);
            currentB = Math.min(costs[i][1] + preR, costs[i][1] + preG);
            currentG = Math.min(costs[i][2] + preR, costs[i][2] + preB);

            preR = currentR;
            preB = currentB;
            preG = currentG;
        }

        return Math.min(currentR, Math.min(currentB, currentG));
    }


    public static void main(String[] args) {
        int[][] costs = new int[][]{
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };
        System.out.println(minCost1(costs));
        System.out.println(minCost2(costs));
        System.out.println(minCost3(costs));
        System.out.println(minCost4(costs));

    }


}
