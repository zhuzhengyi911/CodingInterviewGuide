package book.chapter2_LinkedList.topic3_RemoveMiddle;

/**
 * @program: CodingInterviewGuide
 * @description: 删除链表的中间节点，和a/b处的节点
 * @author: Zhu Zheng-yi
 * @create: 2020-05-14 19:17
 **/

public class RemoveMiddle {

    public static Node removeMiddle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        if (head.next.next == null) {
            return head;
        }


        Node pre = head;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            pre = pre.next;
            fast = fast.next.next;
        }

        pre.next = pre.next.next;

        return head;
    }


    public static Node removeByRatio(Node head, int a, int b) {
        if (head == null) {
            return head;
        }

        int n = 0;
        Node p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        n = (int) Math.ceil(((double) (n * a)) / b);


        if (n == 1) {
            head = head.next;
        }

        if (n > 1) {
            p = head;
            while (--n != 1) {
                p = p.next;
            }
            p.next = p.next.next;
        }
        return head;
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

//        head = removeMiddle(head);
        head = removeByRatio(head, 2, 3);

        p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

    }


}
