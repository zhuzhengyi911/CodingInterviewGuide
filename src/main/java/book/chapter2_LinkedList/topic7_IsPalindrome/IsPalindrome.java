package book.chapter2_LinkedList.topic7_IsPalindrome;

import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 判断单链表是否是回文
 * @author: Zhu Zheng-yi
 * @create: 2020-05-14 20:40
 **/

public class IsPalindrome {


    /**
     * 用栈
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(Node head) {
        if (head == null) {
            return false;
        }

        Stack<Node> stack = new Stack<>();
        Node p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        p = head;
        while (p != null && p.val == stack.peek().val) {
            p = p.next;
            stack.pop();
        }

        return stack.isEmpty() ? true : false;
    }


    /**
     * 栈（对折）,可节省一半空间
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head) {
        if (head == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null){
            stack.push(slow);
        }
        slow = slow.next;

        while (slow!=null && slow.val == stack.peek().val){
            slow = slow.next;
            stack.pop();
        }
        return stack.isEmpty();
    }


    /**
     *
     * 逆序后半部分链表
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome3(Node head) {
        if (head == null){
            return false;
        }

        Node node1 = head;
        Node node2 = head;
        // 查找中间节点
        while (node2.next != null && node2.next.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
        }

        // 逆序右半部分
        node2 = node1.next;
        node1.next = null;
        Node node3;

        while (node2 != null){
            node3 = node2.next;
            node2.next = node1;
            node1=node2;
            node2=node3;
        }

        // 比较
        boolean res = true;
        node2 = head;
        node3 = node1;

        while (node2!=null && node1 != null){
            if (node2.val != node1.val){
                res = false;
                break;
            }
            node2 = node2.next;
            node1 = node1.next;
        }


        // 恢复原顺序
        node1 = node3.next;
        node3.next = null;

        while (node1 != null){
            node2 = node1.next;
            node1.next = node3;
            node3=node1;
            node1=node2;
        }

        return res;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3,3, 2, 1
        };

        Node head = new Node(nums[0]);

        Node pre = head;
        Node p = null;
        for (int i = 1; i < nums.length; i++) {
            p = new Node(nums[i]);
            pre.next = p;
            pre = p;
        }
        System.out.println(isPalindrome1(head));
        System.out.println(isPalindrome2(head));
        System.out.println(isPalindrome3(head));


    }
}
