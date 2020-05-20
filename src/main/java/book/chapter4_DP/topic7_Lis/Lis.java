package book.chapter4_DP.topic7_Lis;

public class Lis {


    /**
     * O(N2)
     *
     * @param arr
     * @return
     */
    public static int[] getDp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }

        int[] lis = new int[len];
        lis[--len] = arr[index];

        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] + 1 == dp[index]) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    public static int[] lis(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getDp2(arr);

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        return generateLIS(arr, dp);
    }


    public static int[] getDp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];

        dp[0] = 1;
        ends[0] = arr[0];
        int right = 0;

        int index;

        for (int i = 1; i < arr.length; i++) {
            index = bSearch(ends,0,right,arr[i]);
            right = Math.max(right,index);
            ends[index] = arr[i];
            dp[i] = index + 1;
        }
        return dp;
    }


    public static int bSearch(int[] arr, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] lis = lis(arr);
        for (int i = 0; i < lis.length; i++) {
            System.out.print(lis[i] + " ");
        }
    }
}
