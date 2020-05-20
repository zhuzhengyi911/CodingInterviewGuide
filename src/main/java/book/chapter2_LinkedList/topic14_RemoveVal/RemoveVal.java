package book.chapter2_LinkedList.topic14_RemoveVal;

/**
 * @program: CodingInterviewGuide
 * @description: 删除指定值的结点
 * @author: Zhu Zheng-yi
 * @create: 2020-05-19 18:14
 **/

public class RemoveVal {


    public static Node removeVal1(Node head, int val) {
        while (head != null){
            if (head.val == val){
                head = head.next;
            }else {
                break;
            }
        }

        Node pre = head;
        Node p = head.next;

        while (p!= null){
            if (p.val == val){
                pre.next = p.next;
            }else {
                pre = p;
            }
            p = p.next;
        }

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

        int[] nums = new int[]{
                2, 2, 2, 2, 1, 2, 2, 3, 3, 3, 2, 2, 2, 2, 2, 6, 2, 2
        };

        Node head = createLink(nums);

        head = removeVal1(head,2 );

        printLink(head);
    }
}
