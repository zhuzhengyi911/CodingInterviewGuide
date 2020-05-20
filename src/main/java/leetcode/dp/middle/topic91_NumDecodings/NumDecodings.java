package leetcode.dp.middle.topic91_NumDecodings;

/**
 * @program: CodingInterviewGuide
 * @description: 91. 解码方法
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 08:34
 **/

public class NumDecodings {


    public static int numDecodings1(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = 0;

            int num = char2int(s.charAt(i - 1));
            if (num > 0){
                dp[i] += dp[i - 1];
            }

            num = char2int(s.charAt(i - 2),s.charAt(i - 1));
            if (num<=26 && num>=10){
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static int char2int(int c1){
        return c1 - '0';
    }

    public static int char2int(int c1,int c2){
        return char2int(c1) * 10 + char2int(c2);
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(numDecodings1(s));

    }


}
