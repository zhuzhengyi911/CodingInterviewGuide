package leetcode.heap.topic23_MergeKLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: CodingInterviewGuide
 * @description: 23. 合并K个排序链表
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 21:02
 **/

public class MergeKLists {


    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode p;
        for (ListNode head : lists){
            p = head;
            while (p != null){
                heap.offer(p);
                p = p.next;
            }
        }

        ListNode h = heap.poll();
        p = h;
        ListNode pre = p;
        while (!heap.isEmpty()){
            p = heap.poll();
            p.next = null;
            pre.next = p;
            pre = p;
        }
        return h;
    }


}
