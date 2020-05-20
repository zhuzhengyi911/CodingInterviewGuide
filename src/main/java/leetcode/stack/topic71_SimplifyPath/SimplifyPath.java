package leetcode.stack.topic71_SimplifyPath;

import java.time.temporal.ChronoField;
import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 71. 简化路径
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 15:28
 **/

public class SimplifyPath {


    /**
     *
     * 栈
     *
     * 无法处理 /...
     *
     * @param path
     * @return
     */
    public static String simplifyPath1(String path) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < path.length(); i++){
            if (stack.isEmpty()){
                stack.push('/');
            }
            char c = path.charAt(i);
            if (c == '/'){
                if (stack.peek() != '/'){
                    stack.push(c);
                }
            }else if (c == '.'){
                while (stack.peek() != '/'){
                    stack.pop();
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()){
            stack.push('/');
        }else if (stack.peek() == '/' && stack.size() > 1){
            stack.pop();
        }

        Stack<Character> reStack = new Stack<>();
        while (!stack.isEmpty()){
            reStack.push(stack.pop());
        }

        StringBuilder builder = new StringBuilder();
        while (!reStack.isEmpty()){
            builder.append(reStack.pop());
        }
        return builder.toString();
    }


    public static String simplifyPath2(String path) {

        String[] list  = path.split("/");

        Stack<String> stack  = new Stack<>();

        for (String s : list){
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else if (!s.equals(".") && !s.equals("")){
                stack.push(s);
            }
        }


        Stack<String> reStack = new Stack<>();
        while (!stack.isEmpty()){
            reStack.push(stack.pop());
        }

        StringBuilder builder = new StringBuilder();
        if (reStack.isEmpty()){
            builder.append("/");
        }else {
            while (!reStack.isEmpty()){
                builder.append("/");
                builder.append(reStack.pop());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath2(path));

    }

}
