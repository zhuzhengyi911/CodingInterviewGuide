package book.chapter2_LinkedList.topic10_AddList;

import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 两个单链表生成相加链表
 * @author: Zhu Zheng-yi
 * @create: 2020-05-19 14:10
 **/

public class AddList {


    /**
     *
     * 栈逆序
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node addLinks1(Node head1, Node head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Node p = head1;
        while (p != null) {
            stack1.push(p.val);
            p = p.next;
        }

        p = head2;
        while (p != null) {
            stack2.push(p.val);
            p = p.next;
        }

        Node head = null;
        int carry = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int n1 = stack1.pop();
            int n2 = stack2.pop();
            int val = n1 + n2 + carry;

            p = new Node(val % 10);
            p.next = head;
            head = p;

            carry = val / 10;
        }

        if (!stack2.isEmpty()) {
            stack1 = stack2;
        }

        while (!stack1.isEmpty()) {
            int val = stack1.pop() + carry;

            p = new Node(val % 10);
            p.next = head;
            head = p;

            carry = 0;
        }

        return head;
    }


    /**
     *
     * 反转链表
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node addLinks2(Node head1, Node head2) {
        head1 = reverseLink(head1);
        head2 = reverseLink(head2);

        Node p1 = head1;
        Node p2 = head2;
        Node head = null;
        Node p;
        int carry = 0;
        while (p1 != null && p2 != null) {
            int n1 = p1.val;
            int n2 = p2.val;
            int val = n1 + n2 + carry;

            p = new Node(val % 10);
            p.next = head;
            head = p;
            carry = val / 10;

            p1 = p1.next;
            p2 = p2.next;
        }

        if (p2 != null){
            p1 = p2;
        }

        while (p1 != null){
            int val = carry + p1.val;

            p = new Node(val % 10);
            p.next = head;
            head = p;

            p1= p1.next;
            carry = 0;
        }

        head1 = reverseLink(head1);
        head2 = reverseLink(head2);
        return head;
    }


    private static Node reverseLink(Node head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        Node pre = null;
        Node p = head;
        Node next;

        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
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
        int[] nums1 = new int[]{
                1,9,9,0
        };

        int[] nums2 = new int[]{
                1, 0
        };

        Node head1 = createLink(nums1);
        Node head2 = createLink(nums2);

        Node head = addLinks2(head1, head2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


}
