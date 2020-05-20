package book.chapter1_StackAndQueue.topic5;

import java.util.Stack;

public class StackTool {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        int current;
        while (!stack.isEmpty()){
            current = stack.pop();
            while (!help.isEmpty() && help.peek() < current){
                stack.push(help.pop());
            }
            help.push(current);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        int[] data = {3, 2, 6, 1, 7, 8, 9, 4};
        Stack<Integer> stack = new Stack<>();
        for (int n : data) {
            stack.push(n);
        }
        sortStackByStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
