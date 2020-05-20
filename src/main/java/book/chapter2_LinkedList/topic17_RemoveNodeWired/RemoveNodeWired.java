package book.chapter2_LinkedList.topic17_RemoveNodeWired;

/**
 * @program: CodingInterviewGuide
 * @description: 用覆盖的方法删除值
 * @author: Zhu Zheng-yi
 * @create: 2020-05-19 20:06
 **/

public class RemoveNodeWired {

    public static void removeNodeWired(Node node){
        if (node == null) {
            return;
        }
        Node next = node.next;
        if (next == null){
            throw  new RuntimeException("can't remove last node.");
        }

        node.val = next.val;
        node.next = next.next;
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
                1,2,3
        };

        Node head = createLink(nums);

        Node node = head.next.next;

        removeNodeWired(node);

        printLink(head);
    }
}
