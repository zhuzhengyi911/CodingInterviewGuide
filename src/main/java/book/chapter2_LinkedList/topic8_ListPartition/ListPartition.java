package book.chapter2_LinkedList.topic8_ListPartition;

/**
 * @program: CodingInterviewGuide
 * @description: 链表的大中小分割
 * @author: Zhu Zheng-yi
 * @create: 2020-05-14 21:34
 **/

public class ListPartition {


    /**
     * 复用数组的Partition代码
     *
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }

        int len = 0;

        Node cur = head;

        while (cur != null) {
            len++;
            cur = cur.next;
        }

        Node[] nodeArr = new Node[len];
        cur = head;
        for (int i = 0; i < len; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }

        arrPartition(nodeArr, pivot);

        for (int i = 0; i < len - 1; i++) {
            nodeArr[i].next = nodeArr[i + 1];
        }
        nodeArr[len - 1].next = null;

        return nodeArr[0];
    }

    private static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;

        while (index != big) {
            if (nodeArr[index].val < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].val == pivot) {
                index++;
            } else {
                swap(nodeArr, index, --big);
            }

        }

    }

    private static void swap(Node[] nodeArr, int a, int b) {
        Node temp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = temp;
    }


    /**
     * 使用大中小三个链表
     *
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;

        Node cur = head;
        Node next = cur.next;

        while (cur != null) {
            next = cur.next;
            cur.next = null;

            if (cur.val < pivot) {
                if (sH == null) {
                    sH = cur;
                    sT = cur;
                } else {
                    sT.next = cur;
                    sT = cur;
                }
            } else if (cur.val == pivot) {
                if (eH == null) {
                    eH = cur;
                    eT = cur;
                } else {
                    eT.next = cur;
                    eT = cur;
                }
            } else {
                if (bH == null) {
                    bH = cur;
                    bT = cur;
                } else {
                    bT.next = cur;
                    bT = cur;
                }
            }

            cur = next;
        }


        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{
                9, 0, 4, 5, 1, 3, 3, 8
        };

        Node head = new Node(nums[0]);

        Node pre = head;
        Node p;
        for (int i = 1; i < nums.length; i++) {
            p = new Node(nums[i]);
            pre.next = p;
            pre = p;
        }

//        head = listPartition1(head, 3);
        head = listPartition2(head, 3);
        p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

    }
}
