package book.chapter2_LinkedList.topic9_CopyListWithRandom;

import java.util.HashMap;

/**
 * @program: CodingInterviewGuide
 * @description: 复制含有随机指针的链表
 * @author: Zhu Zheng-yi
 * @create: 2020-05-14 22:09
 **/

public class CopyListWithRandom {


    /**
     *
     * 使用Hash表缓存
     *
     * @param head
     * @return
     */
    public static Node copyListWithRandom1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;

        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = cur.next;
            map.get(cur).rand = cur.rand;
            cur = cur.next;
        }
        return map.get(head);
    }


}
