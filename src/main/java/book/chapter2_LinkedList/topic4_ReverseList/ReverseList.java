package book.chapter2_LinkedList.topic4_ReverseList;

/**
 * @program: CodingInterviewGuide
 * @description: 翻转链表
 * @author: Zhu Zheng-yi
 * @create: 2020-05-14 19:35
 **/

public class ReverseList {


    public static Node reverseList(Node head) {
        Node pre = null;
        Node p = head;
        Node next;
        while (p!=null){
            next = p.next;
            p.next = pre;
            pre = p;
            p=next;
        }
        return pre;
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode p = head;
        DoubleNode next ;
        while (p!=null){
            next = p.next;
            p.next = pre;
            p.pre = next;
            pre = p;
            p = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 4, 5, 6
        };

        Node head = new Node(nums[0]);
        Node pre = head;
        Node p;
        for (int i = 1; i < nums.length; i++) {
            p = new Node(nums[i]);
            pre.next = p;
            pre = p;
        }

        head = reverseList(head);

        p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

        // DoubleLink
        DoubleNode headD = new DoubleNode(nums[0]);
        DoubleNode preD = headD;
        DoubleNode pD;

        for (int i = 1; i < nums.length; i++) {
            pD = new DoubleNode(nums[i]);
            preD.next = pD;
            pD.pre = preD;
            preD = pD;
        }

        headD = reverseList(headD);

        pD = headD;
        while (pD != null) {
            System.out.print(pD.val + " ");
            pD = pD.next;
        }
    }

}
