package book.chapter1_StackAndQueue.topic3_ReverseStack;

import java.util.Stack;

/**
 *
 */
public class ReverseStack2 {

    private static int getAndRemoveLastElement(Stack<Integer> stack){
        int peek = stack.pop();
        if (stack.isEmpty()){
            return peek;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(peek);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }



    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            s.push(data[i]);
        }
        reverse(s);
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
