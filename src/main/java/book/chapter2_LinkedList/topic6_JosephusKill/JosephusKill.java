package book.chapter2_LinkedList.topic6_JosephusKill;

/**
 * @program: CodingInterviewGuide
 * @description: 环形单向链表的约瑟夫问题
 * @author: Zhu Zheng-yi
 * @create: 2020-05-14 20:23
 **/

public class JosephusKill {


    public static Node josephusKill1(Node head,int m){
        if (head == null || head.next == head || m < 1){
            return head;
        }

        Node pre = head;
        Node p = head;

        while (pre.next != p){
            pre = pre.next;
        }
        int count = 0;

        while (pre != p){
            if (++count == m){
                pre.next = p.next;
                count=0;
            }else {
                pre = pre.next;
            }
            p = pre.next;
        }
        return p;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 4, 5, 6
        };

        Node head = new Node(nums[0]);

        Node pre = head;
        Node p = null;
        for (int i = 1; i < nums.length; i++) {
            p = new Node(nums[i]);
            pre.next = p;
            pre = p;
        }
        p.next = head;


        System.out.print(josephusKill1(head,3 ).val);




    }
}
