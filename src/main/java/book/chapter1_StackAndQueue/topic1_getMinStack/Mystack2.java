package book.chapter1_StackAndQueue.topic1_getMinStack;

import java.util.Stack;

public class Mystack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack2(){
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }


    public void push(int newNum){
        if (stackMin.isEmpty()){
            stackMin.push(newNum);
        }else if (newNum < getMin()){
            stackMin.push(newNum);
        }else {
            stackMin.push(getMin());
        }
        stackData.push(newNum);
    }

    public int pop(){
        if (stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin(){
        if (stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        Mystack2 s = new Mystack2();
        int[] data = {3,4,5,1,2,1};
        for (int i = 0;i<data.length;i++){
            System.out.println("push "+data[i]);
            s.push(data[i]);
            System.out.println("min "+s.getMin());
        }
    }


}
