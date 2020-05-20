package book.chapter2_LinkedList.topic2_RemoveLastKthNode;

/**
 * @program: CodingInterviewGuide
 * @description: 删除链表的倒数第K个节点
 * @author: Zhu Zheng-yi
 * @create: 2020-05-14 18:51
 **/

public class RemoveLastKthNode {


    public static Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }

        Node p = head;

        while (p != null) {
            lastKth--;
            p = p.next;
        }

        if (lastKth > 0) {
            return head;
        }

        if (lastKth == 0) {
            head = head.next;
            return head;
        }

        p = head;
        while (++lastKth != 0) {
            p = p.next;
        }

        p.next = p.next.next;


        return head;
    }

    public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }

        DoubleNode p = head;

        while (p != null) {
            lastKth--;
            p = p.next;
        }

        if (lastKth > 0) {
            return head;
        }

        if (lastKth == 0) {
            head = head.next;
            head.pre = null;
            return head;
        }

        p = head;
        while (++lastKth != 0) {
            p = p.next;
        }

        DoubleNode nextNext = p.next.next;

        p.next = nextNext;
        if (nextNext != null){
            nextNext.pre = p;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 4, 5, 6
        };
        int lastKth = 3;
        Node head = new Node(nums[0]);
        Node pre = head;
        Node p;
        for (int i = 1; i < nums.length; i++) {
            p = new Node(nums[i]);
            pre.next = p;
            pre = p;
        }

        head = removeLastKthNode(head, lastKth);

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

        headD = removeLastKthNode(headD, lastKth);

        pD = headD;
        while (pD != null) {
            System.out.print(pD.val + " ");
            pD = pD.next;
        }

    }


}
