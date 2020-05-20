package book.chapter1_StackAndQueue.topic1_getMinStack;

import java.util.Stack;

/**
 * 包含getMin功能的栈
 * pop,push,getMin功能的时间复杂度都为O（1）
 */
public class Mystack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack1(){
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int newNum){
        if (stackMin.isEmpty()){
            stackMin.push(newNum);
        }else if (newNum <= getMin()){
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public int pop(){
        if (stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }

        int value = stackData.pop();
        if (value == getMin()){
            stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        if (stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        Mystack1 s = new Mystack1();
        int[] data = {3,4,5,1,2,1};
        for (int i = 0;i<data.length;i++){
            System.out.println("push "+data[i]);
            s.push(data[i]);
            System.out.println("min "+s.getMin());
        }
    }
}
