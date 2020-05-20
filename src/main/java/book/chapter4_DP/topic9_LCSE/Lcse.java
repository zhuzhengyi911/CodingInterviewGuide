package book.chapter4_DP.topic9_LCSE;

public class Lcse {

    public static int[][] getDp(char[] chs1, char[] chs2) {
        int m = chs1.length;
        int n = chs2.length;
        int[][] dp = new int[m][n];

        dp[0][0] = chs1[0] == chs2[2] ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = chs1[i] == chs2[0] ? 1 : dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = chs1[0] == chs2[j] ? 1 : dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                if (chs1[i] == chs2[j]){
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    public static String lcse(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getDp(chs1, chs2);
        int m = chs1.length;
        int n = chs2.length;

        System.out.println(dp[chs1.length - 1][chs2.length - 1]);
        printMatrix(dp);

        char[] res = new char[dp[m - 1][n - 1]];
        int index = dp[m - 1][n - 1] - 1;
        int i = m - 1;
        int j = n - 1;
        while (index >= 0){
            if (i > 0 && dp[i - 1][j] == dp[i][j]){
                // 上
                i--;
            }else if(j > 0 && dp[i][j - 1] == dp [i][j]){
                // 左
                j--;
            }else {
                // 左上
                res[index--] = chs1[i];
                i--;
                j--;
            }
        }
        return String.valueOf(res);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";
        System.out.println(lcse(str1, str2));
    }

}