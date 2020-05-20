package book.chapter4_DP.topic10_LCST;

public class Lcst {

    public static int[][] getDp(char[] chs1, char[] chs2) {
        int m = chs1.length;
        int n = chs2.length;
        int[][] dp = new int[m][n];

        dp[0][0] = chs1[0] == chs2[0] ? 1 : 0;

        for (int i = 1; i < m; i++) {
            dp[i][0] = chs1[i] == chs2[0] ? 1 : 0;
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = chs1[0] == chs2[j] ? 1 : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = chs1[i] == chs2[j] ? dp[i - 1][j - 1] + 1 : 0;
            }
        }
        return dp;
    }

    public static String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getDp(chs1, chs2);
        int m = chs1.length;
        int n = chs2.length;
        printMatrix(dp);

        int max = 0;
        int end = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (max < dp[i][j]) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
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
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        System.out.println(lcst1(str1, str2));
    }
}
