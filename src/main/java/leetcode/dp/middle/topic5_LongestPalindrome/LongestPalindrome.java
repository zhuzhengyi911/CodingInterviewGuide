package leetcode.dp.middle.topic5_LongestPalindrome;

/**
 * @program: CodingInterviewGuide
 * @description: 5. 最长回文子串
 * @author: Zhu Zheng-yi
 * @create: 2020-05-08 19:21
 **/

public class LongestPalindrome {


    /**
     * 中心扩展法
     * <p>
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();

        int maxLen = 0;
        String res = "";


        for (int i = 0; i < chars.length; i++) {
            // 奇回文
            int l = i - 1;
            int r = i + 1;

            while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
                l--;
                r++;
            }
            int len = r - l - 1;
            if (len > maxLen) {
                maxLen = len;
                res = s.substring(l + 1, r);
            }

            // 偶回文
            l = i;
            r = i + 1;

            while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
                l--;
                r++;
            }
            len = r - l - 1;
            if (len > maxLen) {
                maxLen = len;
                res = s.substring(l + 1, r);
            }
        }
        return res;
    }


    /**
     * Manacher算法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        char[] charArr = manacherString(s);

        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;

        for (int i = 0;i < charArr.length;i++){
            pArr[i] = pR > i ? Math.min(pArr[index * 2 - i], pR - i): 1;

            while (i + pArr[i] < charArr.length && i - pArr[i] >= 0){
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }

            if (i + pArr[i] > pR){
                pR = i + pArr[i];
                index = i;
            }
        }

        int max = 0;
        int center = 0;
        for (int i = 0;i < pArr.length;i++){
            if (pArr[i] > max){
                max = pArr[i];
                center = i;
            }
        }
        return s.substring((center - pArr[center] + 1) / 2, (center + pArr[center] - 1) / 2);
    }


    /**
     * 解决奇偶回文问题
     * @param str
     * @return
     */
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = i%2 == 0 ? '#' : charArr[index++];
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "abbacba";
        System.out.println(longestPalindrome1(s));
        System.out.println(longestPalindrome2(s));
    }


}
