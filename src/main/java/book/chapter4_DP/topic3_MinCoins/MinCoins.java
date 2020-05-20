package book.chapter4_DP.topic3_MinCoins;

public class MinCoins {


    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        int res = -1;
        for (int k = 0; rest >= arr[index] * k; k++) {
            int next = process1(arr, index + 1, rest - arr[index] * k);
            if (next != -1) {
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }


    /**
     * 直接翻译的DP
     * @param arr
     * @param aim
     * @return
     */
    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int res = -1;
                for (int k = 0; rest >= arr[index] * k;k++){
                    int next = dp[index + 1][rest - arr[index] * k];
                    if (next != -1){
                           res = res == -1 ? next + k : Math.min(res,next + k);
                    }
                }
                dp[index][rest] = res;
            }
        }
        return dp[0][aim];
    }

    public static int minCoins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int res = -1;
                if (dp[index + 1][rest] != -1){
                    res = dp[index + 1][rest];
                }

                if (rest - arr[index] >=0 && dp[index][rest - arr[index]] != -1){
                    res = res == -1 ? dp[index][rest - arr[index]] + 1 : Math.min(res,dp[index][rest - arr[index]] + 1);
                }
                dp[index][rest] = res;
            }
        }
        return dp[0][aim];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 25, 1};
        int aim = 55;
        System.out.println(minCoins1(arr, aim));
        System.out.println(minCoins2(arr, aim));
        System.out.println(minCoins3(arr, aim));
    }


}
