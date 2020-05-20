package book.chapter2_LinkedList.topic11_GetIntersectNode;

/**
 * @program: CodingInterviewGuide
 * @description: 两个单链表相交的一系列问题
 * @author: Zhu Zheng-yi
 * @create: 2020-05-19 15:19
 **/

public class GetIntersectNode {


    /**
     * 返回第一个如环的结点，没有返回null
     * <p>
     * 可证明
     *
     * @param head
     * @return
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 两个无环链表是否相交
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node p1 = head1;
        Node p2 = head2;

        int n = 0;

        while (p1.next != null) {
            p1 = p1.next;
            n++;
        }

        while (p2.next != null) {
            p2 = p2.next;
            n--;
        }

        if (p1 != p2) {
            return null;
        }

        // p1 长 p2 短
        p1 = n >= 0 ? head1 : head2;
        p2 = p1 == head1 ? head2 : head1;
        n = Math.abs( n);
        while (n > 0) {
            p1 = p1.next;
            n--;
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }


    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node p1;
        Node p2;
        if (loop1 == loop2) {
            p1 = head1;
            p2 = head2;

            int n = 0;

            while (p1 != loop1) {
                n++;
                p1 = p1.next;
            }

            while (p2 != loop1) {
                n--;
                p2 = p2.next;
            }

            p1 = n >= 0 ? head1 : head2;
            p2 = p1 == head1 ? head2 : head1;

            n = Math.abs( n);
            while (n >0){
                n--;
                p1=p1.next;
            }

            while (p1!= p2){
                p1=p1.next;
                p2=p2.next;
            }
            return p1;
        } else {
            p1 = loop1.next;
            while (p1 != loop1) {
                if (p1 == loop2) {
                    return loop1;
                }
                p1 = p1.next;
            }
        }
        return null;
    }



    public static Node getIntersectNode(Node head1,Node head2){
        if (head1 == null|| head2 == null){
            return null;
        }

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }

        if (loop1!=null&& loop2!=null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }


    public static void main(String[] args) {
//        // test getLoopNode
//        Node n1 = new Node(1);
//        Node n2 = new Node(2);
//        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        Node n5 = new Node(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n4;
//        System.out.println(getLoopNode(n1).val);


//        // test noLoop
//        Node n1n1 = new Node(1);
//        Node n1n2 = new Node(2);
//        Node n1n3 = new Node(3);
//
//        Node n2n1 = new Node(1);
//
//        Node c1 = new Node(4);
//        Node c2 = new Node(5);
//        Node c3 = new Node(6);
//
//        n1n1.next = n1n2;
//        n1n2.next = n1n3;
//        n1n3.next = c1;
//
//        n2n1.next = c1;
//
//        c1.next = c2;
//        c2.next = c3;
//        c3.next = null;
//
//        System.out.println(noLoop(n1n1, n2n1).val);

        // test bothLoop
        Node n1n1 = new Node(1);
        Node n1n2 = new Node(2);
        Node n1n3 = new Node(3);

        Node n2n1 = new Node(1);

        Node c1 = new Node(4);
        Node c2 = new Node(5);
        Node c3 = new Node(6);

        n1n1.next = n1n2;
        n1n2.next = n1n3;
        n1n3.next = c1;

        n2n1.next = c1;

        c1.next = c2;
        c2.next = c3;
        c3.next = c1;

        System.out.println(bothLoop(n1n1,c1,n2n1,c1).val);


    }


}
