package book.chapter2_LinkedList.topic19_Merge;

/**
 * @program: CodingInterviewGuide
 * @description: 两个有序的单链表合并
 * @author: Zhu Zheng-yi
 * @create: 2020-05-19 20:15
 **/

public class Merge {


    public static Node merge(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }

        Node head = head1.val <= head2.val ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;

        Node pre = null;
        Node next = null;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }

        pre.next = cur1 == null ? cur2 : cur1;
        return head;
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

        int[] nums1 = new int[]{
                1, 5, 6, 7, 12, 13
        };

        int[] nums2 = new int[]{
                1, 2, 8, 9, 10
        };

        Node head1 = createLink(nums1);
        Node head2 = createLink(nums2);


        Node merge = merge(head1, head2);

        printLink(merge);
    }


}
