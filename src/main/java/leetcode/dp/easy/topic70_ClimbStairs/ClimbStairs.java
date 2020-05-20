package leetcode.dp.easy.topic70_ClimbStairs;

import java.util.HashMap;

public class ClimbStairs {


    /**
     * 暴力
     *
     * 时间复杂度:O(2^n)     解释：树形递归，树的大小为2^n
     * 空间复杂度:O(n)       解释：树的深度为n
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        return process1(n);
    }

    public static int process1(int rest) {
        if (rest < 0) {
            return 0;
        } else if (rest == 0) {
            return 1;
        }
        return process1(rest - 1) + process1(rest - 2);
    }


    /**
     * 记忆法
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)       解释：需要记忆n个结果
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return process2(map, n);
    }

    public static int process2(HashMap<Integer, Integer> map, int rest) {
        if (rest < 0) {
            return 0;
        } else if (rest == 0) {
            return 1;
        }

        int result1;
        int result2;
        if (map.containsKey(rest - 1)) {
            result1 = map.get(rest - 1);
        } else {
            result1 = process2(map, rest - 1);
            map.put(rest - 1, result1);
        }

        if (map.containsKey(rest - 2)) {
            result2 = map.get(rest - 2);
        } else {
            result2 = process2(map, rest - 2);
            map.put(rest - 2, result2);
        }

        return result1 + result2;
    }


    /**
     * dp
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if (n <= 0){
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp [i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * dp空间压缩
     * 此时代码类似于斐波那契数列
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param n
     * @return
     */
    public static int climbStairs4(int n) {
        if (n <= 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }

        int pre1 = 2;
        int pre2 = 1;
        int current = 0;
        for (int i = 3; i <= n; i++) {
            current = pre1 + pre2;
            pre2 = pre1;
            pre1 = current;
        }
        return current;
    }


    public static void main(String[] args) {
        //System.out.println(climbStairs1(44));
        System.out.println(climbStairs2(2));
        System.out.println(climbStairs3(2));
        System.out.println(climbStairs4(2));

    }

}
