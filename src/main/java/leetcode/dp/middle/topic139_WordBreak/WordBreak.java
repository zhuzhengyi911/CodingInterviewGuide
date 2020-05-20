package leetcode.dp.middle.topic139_WordBreak;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: CodingInterviewGuide
 * @description: 139. 单词拆分
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 09:59
 **/

public class WordBreak {


    /**
     * DP
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {

        String[] ss = {
                "leet", "code"
        };


        List<String> wordDict = new LinkedList<>();
        for (String s : ss) {
            wordDict.add(s);
        }
        String s = "leetcode";
        System.out.println(wordBreak(s, wordDict));
    }


}
