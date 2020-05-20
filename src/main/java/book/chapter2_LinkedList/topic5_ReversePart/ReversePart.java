package book.chapter2_LinkedList.topic5_ReversePart;

/**
 * @program: CodingInterviewGuide
 * @description: 翻转部分单链表
 * @author: Zhu Zheng-yi
 * @create: 2020-05-14 19:49
 **/

public class ReversePart {


    public static Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;

        while (node1 != null) {
            len++;
            System.out.println(len);
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }

        if (from > to || from < 1 || to > len) {
            return head;
        }

        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;

        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 =next;
        }

        if (fPre!=null){
            fPre.next = node1;
            return head;
        }
        return node1;
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

        head = reversePart(head, 1, 4);

        p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
