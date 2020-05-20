package book.chapter4_DP.topic5_Coins;

import java.util.HashMap;

public class Coins {

    /**
     * 最初步的暴力方法
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; aim - arr[index] * i >= 0; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }


    /**
     * 记忆优化法
     * <p>
     * 可以使用数组 map[][]
     * 也可以使用HashMap
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        HashMap<String, Integer> map = new HashMap<>();

        return process2(arr, 0, aim, map);
    }

    public static int process2(int[] arr, int index, int aim, HashMap<String, Integer> map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; aim - arr[index] * i >= 0; i++) {
                String key = String.valueOf(index + 1) + "_" + String.valueOf(aim - arr[index] * i);
                if (map.containsKey(key)) {
                    res += map.get(key);
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        String key = String.valueOf(index) + "_" + String.valueOf(aim);
        map.put(key, res);
        return res;
    }


    /**
     * DP
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int[][] dp = new int[arr.length][aim + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j <= aim; j++) {
            dp[0][j] = j % arr[0] == 0 ? 1 : 0;
        }


        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                int num = 0;
                for (int k = 0; j >= k * arr[i]; k++) {
                    num += dp[i - 1][j - k * arr[i]];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }


    /**
     * 优化DP
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int[][] dp = new int[arr.length][aim + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j <= aim; j++) {
            dp[0][j] = j % arr[0] == 0 ? 1 : 0;
        }


        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 25, 1};
        int aim = 100;
        System.out.println(coins4(arr, aim));
    }
}
