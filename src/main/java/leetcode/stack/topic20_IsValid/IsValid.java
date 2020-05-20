package leetcode.stack.topic20_IsValid;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 20. 有效的括号
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 14:29
 **/

public class IsValid {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']','[' );
        map.put('}','{' );

        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.peek().equals(map.get(c))){
                    stack.pop();
                }else {
                    flag = false;
                    break;
                }
            }else {
                stack.push(c);
            }
        }

        if (!stack.peek().equals('#')){
            flag = false;
        }

        return flag;
    }


    public static void main(String[] args) {
        String s = "{[()[]{}]}";
        System.out.println(isValid(s));

    }


}
