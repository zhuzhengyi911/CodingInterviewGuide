package leetcode.dp.easy.topic392_IsSubsequence;

/**
 * @program: CodingInterviewGuide
 * @description: 392. 判断子序列
 * @author: Zhu Zheng-yi
 * @create: 2020-05-08 17:07
 **/

public class IsSubsequence {


    public static boolean isSubsequence1(String s, String t) {
        int i = 0;
        int j = 0;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        while (i < s.length() && j < t.length()){
            if (sChars[i] == tChars[j]){
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";

        System.out.println(isSubsequence1(s, t));
    }
}
