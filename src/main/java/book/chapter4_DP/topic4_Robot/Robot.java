package book.chapter4_DP.topic4_Robot;

public class Robot {


    /**
     * 暴力递归方法
     *
     * @param N
     * @param cur
     * @param rest
     * @param P
     * @return
     */
    public static int walk(int N, int cur, int rest, int P) {
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }

        if (cur == 1) {
            return walk(N, 2, rest - 1, P);
        }

        if (cur == N) {
            return walk(N, N - 1, rest - 1, P);
        }

        return walk(N, cur + 1, rest - 1, P) + walk(N, cur - 1, rest - 1, P);

    }

    /**
     * 暴力递归方法
     *
     * @param N
     * @param M
     * @param K
     * @param P
     * @return
     */
    public static int ways1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return walk(N, M, K, P);
    }


    /**
     *
     * @param N
     * @param M
     * @param K
     * @param P
     * @return
     */
    public static int ways2(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }

        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;

        for (int i = 1;i <= K;i++){
            for (int j = 1;j <= N;j++){
                if (j == 1){
                    dp[i][j] = dp[i-1][j+1];
                }else if (j == N){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j+1] + dp[i-1][j-1];
                }

            }
        }
        return dp[K][M];
    }


    public static void main(String[] args) {
        System.out.println(ways1(5, 2, 3, 3));
        System.out.println(ways2(5, 2, 3, 3));
    }


}


