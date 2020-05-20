package book.chapter4_DP.topic6_MaxCoins;

public class MaxCoins {

    /**
     * 暴力方法
     *
     * @param arr
     * @return
     */
    public static int maxCoins1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int N = arr.length;
        int[] help = new int[N + 2];
        help[0] = 1;
        help[N + 1] = 1;
        for (int i = 0; i < arr.length; i++) {
            help[i + 1] = arr[i];
        }
        return process1(help, 1, N);
    }

    public static int process1(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l - 1] * arr[l] * arr[r + 1];
        }

        int max = Math.max(
                arr[l - 1] * arr[l] * arr[r + 1] + process1(arr, l + 1, r),
                arr[l - 1] * arr[r] * arr[r + 1] + process1(arr, l, r - 1)
        );

        for (int i = l + 1; i < r; i++) {
            max = Math.max(
                    max,
                    process1(arr, l, i - 1) + arr[l - 1] * arr[i] * arr[r + 1] + process1(arr, i + 1, r)
            );
        }
        return max;
    }


    /**
     * 修改为DP
     * @param arr
     * @return
     */
    public static int maxCoins2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int N = arr.length;

        int[] help = new int[N + 2];
        help[0] = 1;
        help[N + 1] = 1;
        for (int i = 0; i < arr.length; i++) {
            help[i + 1] = arr[i];
        }

        int[][] dp = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            dp[i][i] = help[i - 1] * help[i] * help[i + 1];
        }

        for (int l = N; l >= 1; l--) {
            for (int r = l + 1;r <= N;r++){
                int res = Math.max(
                        help[l - 1] * help[l] * help[r + 1] + dp[l + 1][r],
                        help[l - 1] * help[r] * help[r + 1] + dp[l][r - 1]
                );

                for (int i = l + 1; i < r; i++) {
                    res = Math.max(
                            res,
                            dp[l][i - 1] + help[l - 1] * help[i] * help[r + 1] + dp[i + 1][r]
                    );
                }
                dp[l][r] = res;
            }
        }
        return dp[1][N];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 5, 1, 6};
        System.out.println(maxCoins1(arr));
        System.out.println(maxCoins2(arr));
    }
}
