package book.chapter1_StackAndQueue.topic6;

/**
 * 递归
 */
public class HanoiProblem1 {
    private int count = 1;

    public int hanoiProblem(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    private void move(int num, String from, String to) {
        System.out.println((count++) + " : Move " + num + " from " + from + " to " + to);
    }

    private int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                move(1, from, to);
                return 1;
            } else {
                move(1, from, mid);
                move(1, mid, to);
                return 2;
            }
        }

        int step1, step2, step3, step4, step5;
        String another;
        if (from.equals(mid) || left.equals(mid)) {
            another = (from.equals(right)) ? left : right;
            step1 = process(num - 1, left, mid, right, from, another);
            step2 = 1;
            move(num, from, mid);
            step3 = process(num - 1, left, mid, right, another, mid);
            return step1 + step2 + step3;
        } else {
            step1 = process(num - 1, left, mid, right, from, to);
            step2 = 1;
            move(num, from, mid);
            step3 = process(num - 1, left, mid, right, to, from);
            step4 = 1;
            move(num, mid, to);
            step5 = process(num - 1, left, mid, right, from, to);
            return step1 + step2 + step3 + step4 + step5;
        }
    }

    public static void main(String[] args) {
        int steps = new HanoiProblem1().hanoiProblem(3, "left", "mid", "right");
        System.out.println("Total steps:" + steps);
    }

}
