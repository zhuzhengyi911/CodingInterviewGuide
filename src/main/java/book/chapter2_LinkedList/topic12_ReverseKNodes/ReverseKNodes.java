package book.chapter2_LinkedList.topic12_ReverseKNodes;

import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 每k个元素逆序单链表
 * @author: Zhu Zheng-yi
 * @create: 2020-05-19 16:27
 **/

public class ReverseKNodes {


    /**
     * 栈
     *
     * @param head
     * @return
     */
    public static Node reverseKNodes1(Node head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head;

        Node tail = null;
        Node p;
        head = null;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;

            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    p = stack.pop();
                    if (tail == null) {
                        head = p;
                        tail = p;
                    } else {
                        tail.next = p;
                        tail = p;
                    }
                    p.next = null;
                }
            }
        }

        while (!stack.isEmpty()) {
            p = stack.pop();
            if (tail == null) {
                head = p;
                tail = p;
            } else {
                tail.next = p;
                tail = p;
            }
            p.next = null;
        }
        return head;
    }


    /**
     * 直接处理
     *
     * @param head
     * @param k
     * @return
     */
    public static Node reverseKNode2(Node head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;

        while (cur != null) {
            next = cur.next;
            if (count == k) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public static void resign2(Node left, Node start, Node end, Node right) {
        Node pre = left;
        Node cur = start;
        Node next;

        while (cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (left != null){
            left.next = end;
        }

        start.next = right;

    }


    /**
     * for test
     *
     * @param nums
     * @return
     */
    public static Node createLink(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Node head = new Node(nums[0]);
        Node p = head;
        Node pre = head;
        for (int i = 1; i < nums.length; i++) {
            p = new Node(nums[i]);
            pre.next = p;
            pre = p;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
        };

        Node head = createLink(nums);
        head = reverseKNode2(head, 5);


        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }


}
