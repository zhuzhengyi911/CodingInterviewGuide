package book.chapter2_LinkedList.topic16_SelectSort;

/**
 * @program: CodingInterviewGuide
 * @description: 单链表的选择排序
 * @author: Zhu Zheng-yi
 * @create: 2020-05-19 19:02
 **/

public class SelectSort {

    public static Node selectSort(Node head) {

        Node tail = null;
        Node small;
        Node smallPre = null;
        Node p = head;

        while (p!=null){
            small = p;
            smallPre = getSmallestPre(head);

            if (smallPre != null){
                small = smallPre.next;
                smallPre.next = small.next;
            }

            p = p==small ? p.next : p;

            if (tail == null){
                head = small;
            }else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }


    /**
     * 找最小值的前驱，若第一个数就是最小值，则返回null
     *
     * @param head
     * @return
     */
    public static Node getSmallestPre(Node head) {
        Node small = head;
        Node smallPre = null;
        Node p = head.next;
        Node pre = head;

        while (p != null) {

            if (p.val < small.val){
                small = p;
                smallPre = pre;
            }
            pre = p;
            p = p.next;
        }
        return smallPre;
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
                3, 2, 5, 8, 4, 7, 6, 9
        };

        Node head = createLink(nums);

        head = selectSort(head);

        printLink(head);
    }


}
