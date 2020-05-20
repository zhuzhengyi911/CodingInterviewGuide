package book.chapter2_LinkedList.topic13_RemoveRep;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: CodingInterviewGuide
 * @description: 删除重复结点
 * @author: Zhu Zheng-yi
 * @create: 2020-05-19 17:06
 **/

public class RemoveRep {


    /**
     * Hashset
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head
     */
    public static void removeRep1(Node head) {
        if (head == null) {
            return;
        }

        HashSet<Integer> set = new HashSet<>();

        Node pre = null;
        Node p = head;
        while (p != null) {
            if (set.contains(p.val)) {
                pre.next = p.next;
            } else {
                set.add(p.val);
                pre = p;
            }
            p = p.next;
        }
    }


    /**
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param head
     */
    public static void removeRep2(Node head) {
        if (head == null) {
            return;
        }

        Node p = head;
        Node q;
        Node pre;
        while (p != null) {
            pre = p;
            q = p.next;
            while (q != null) {
                if (q.val == p.val) {
                    pre.next = q.next;
                } else {
                    pre = q;
                }
                q = q.next;
            }
            p = p.next;
        }
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

    public static void printLink(Node head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 3, 5, 2, 1, 7, 3, 4, 5, 0, 1, 2, 7, 4, 8, 3, 5, 3, 7, 1
        };

        Node head = createLink(nums);

        removeRep2(head);

        printLink(head);

    }
}
