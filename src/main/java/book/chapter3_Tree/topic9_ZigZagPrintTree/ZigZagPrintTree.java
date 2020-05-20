package book.chapter3_Tree.topic9_ZigZagPrintTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: CodingInterviewGuide
 * @description: 二叉树按层打印和ZigZag打印
 * @author: Zhu Zheng-yi
 * @create: 2020-05-13 20:15
 **/

public class ZigZagPrintTree {


    /**
     * 按层打印
     *
     * @param head
     */
    public static void printLevel(Node head) {
        if (head == null) {
            return;
        }

        Node last = head;
        Node nLast = null;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(last);

        int level = 1;

        System.out.print("Level " + (level++) + " : ");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.val + " ");
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }

            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }

            if (head == last && !queue.isEmpty()) {
                System.out.print("\nLevel " + (level++) + " : ");
                last = nLast;
            }
        }
        System.out.println();
    }


    public static void printByZigZag(Node head) {
        if (head == null) {
            return;
        }

        Deque<Node> deque = new LinkedList<>();
        boolean lr = true;
        int level = 1;
        Node last = head;
        Node nLast = null;
        printLevelAndOrientation(level++,lr);
        deque.offerFirst(head);
        while (!deque.isEmpty()){
            if (lr){
                head = deque.pollFirst();
                if (head.left != null){
                    deque.offerLast(head.left);
                }



            }





        }



    }

    private static void printLevelAndOrientation(int level ,boolean lr){
        System.out.print("Level "+level+" from ");
        System.out.print(lr?"left to right : ":"right to left : ");
    }


    /**
     * for test
     *
     * @param levelStr
     * @return
     */
    public static Node reconByLevelString(String levelStr) {

        String[] values = levelStr.split("!");

        int index = 0;

        Queue<Node> queue = new LinkedList<>();
        Node head = generateNodeByString(values[index++]);

        if (head != null) {
            queue.offer(head);
        }

        Node node;

        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }


        }

        return head;
    }

    private static Node generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }

    public static void main(String[] args) {
//        String levelStr = "1!2!3!4!#!5!6!#!#!7!8!#!#!#!#!#!#!";
//        Node head = reconByLevelString(levelStr);
//        printLevel(head);
//        printByZigZag(head);


        int[] nums = new int[]{
                1,2,3,4
        };

        Deque<Integer> deque = new LinkedList<>();

        for (int num : nums){
            deque.offerLast(num);
        }

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());


    }
}
