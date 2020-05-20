package book.chapter1_StackAndQueue.topic3_ReverseStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 利用队列逆序一个栈
 */
public class ReverseStack1 {
    public static void reverse(Stack<Integer> stack){
        Queue<Integer> queue = new LinkedList<>();
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }
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
