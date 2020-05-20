package book.chapter1_StackAndQueue.topic6;

import java.util.Stack;

public class HanoiProblem2 {

    private enum Action {
        NO, LtoM, MtoL, MtoR, RtoM;
    }

    private int count = 1;

    public int hanoiprblem(int num, String left, String mid, String right) {
        Stack<Integer> stackL = new Stack<>();
        Stack<Integer> stackM = new Stack<>();
        Stack<Integer> stackR = new Stack<>();
        Stack<Action> trace = new Stack<>();
        trace.push(Action.NO);

        int steps = 0;

        for (int i = num; i > 0 ; i--) {
            stackL.push(i);
        }

        while (stackR.size() != num) {
            steps += tryMove(trace, Action.MtoL, Action.LtoM, stackL, stackM, left, mid);
            steps += tryMove(trace, Action.LtoM, Action.MtoL, stackM, stackL, mid, left);
            steps += tryMove(trace, Action.RtoM, Action.MtoR, stackM, stackR, mid, right);
            steps += tryMove(trace, Action.MtoR, Action.RtoM, stackR, stackM, right, mid);
        }
        return steps;
    }

    private int tryMove(Stack<Action> trace, Action preNoAction, Action nowAction, Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {

        if (preNoAction == trace.peek()) {
            return 0;
        }

        if (fStack.isEmpty()){
            return 0;
        }

        if (!tStack.isEmpty() && fStack.peek() > tStack.peek()){
            return 0;
        }

        int num = fStack.peek();
        tStack.push(fStack.pop());
        trace.push(nowAction);
        System.out.println((count++) + " : " + "Move " + num + " from " + from + " to " + to);

        return 1;
    }

    public static void main(String[] args) {
        int steps = new HanoiProblem2().hanoiprblem(3, "left", "mid", "right");
        System.out.println("Total steps : " + steps);
    }
}
