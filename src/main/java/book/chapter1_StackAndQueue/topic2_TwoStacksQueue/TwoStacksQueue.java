package book.chapter1_StackAndQueue.topic2_TwoStacksQueue;

import java.util.Stack;

/**
 * 通过两个栈实现队列
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /**
     * 将stackPush中所有的元素倒入stackPop
     */
    private void pushToPop(){
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int newNum){
        stackPush.push(newNum);
        pushToPop();
    }

    public int poll(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }





}
