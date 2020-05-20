package book.chapter3_Tree.topic5_Morris;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: CodingInterviewGuide
 * @description: Morris遍历
 * @author: Zhu Zheng-yi
 * @create: 2020-05-13 18:59
 **/

public class Morris {


    /**
     * Morris遍历
     *
     * @param head
     */
    public static void morris(Node head){
        if (head == null){
            return;
        }

        System.out.println("Morris序:");

        Node cur = head;
        Node mostRight = null;

        while (cur != null){

            System.out.print(cur.val + " ");

            if (cur.left != null){
                mostRight = cur.left;

                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                }else {
                    mostRight.right = null;
                    cur = cur.right;
                }

            }else {
                cur = cur.right;
            }
        }

        System.out.println();
    }


    /**
     *
     * 先序
     *
     * @param head
     */
    public static void morrisPre(Node head){
        if (head == null){
            return;
        }

        System.out.println("Morris先序:");

        Node cur = head;
        Node mostRight = null;

        while (cur != null){

            if (cur.left != null){
                mostRight = cur.left;

                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null){
                    // 第一次来到cur
                    System.out.print(cur.val + " ");

                    mostRight.right = cur;
                    cur = cur.left;
                }else {
                    mostRight.right = null;
                    cur = cur.right;
                }

            }else {
                // 只能来一次的节点
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
        System.out.println();
    }


    /**
     *
     * 中序
     *
     * @param head
     */
    public static void morrisIn(Node head){
        if (head == null){
            return;
        }

        System.out.println("Morris中序:");

        Node cur = head;
        Node mostRight = null;

        while (cur != null){

            if (cur.left != null){
                mostRight = cur.left;

                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                }else {
                    // 第二次来到cur
                    System.out.print(cur.val + " ");

                    mostRight.right = null;
                    cur = cur.right;
                }

            }else {
                // 只能来一次的节点
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
        System.out.println();
    }




    /**
     *
     * 后序
     *
     * @param head
     */
    public static void morrisPost(Node head){
        if (head == null){
            return;
        }

        System.out.println("Morris后序:");

        Node cur = head;
        Node mostRight = null;

        while (cur != null){

            if (cur.left != null){
                mostRight = cur.left;

                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                }else {
                    // 第二次来到cur
                    mostRight.right = null;

                    printEdge(cur.left);

                    cur = cur.right;
                }

            }else {
                cur = cur.right;
            }
        }
        System.out.println();
    }


    private static void printEdge(Node head){
        Node tail = reverse(head);

        Node p = tail;
        while (p!=null){
            System.out.print(p.val + " ");
            p = p.right;
        }
        reverse(tail);
    }


    private static Node reverse(Node head){
        Node pre = null;
        Node p = head;
        Node next = null;

        while (p!=null){
            next = p.right;
            p.right = pre;
            pre = p;
            p = next;
        }
        return pre;
    }




    /**
     *
     * for test
     *
     * @param levelStr
     * @return
     */
    public static Node reconByLevelString(String levelStr){

        String[] values = levelStr.split("!");

        int index = 0;

        Queue<Node> queue = new LinkedList<>();
        Node head = generateNodeByString(values[index++]);

        if (head != null){
            queue.offer(head);
        }

        Node node;

        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }


        }

        return head;
    }

    private static Node generateNodeByString(String val){
        if (val.equals("#")){
            return null;
        }
        return new Node(Integer.valueOf(val));
    }

    public static void main(String[] args) {

        String levelStr = "1!2!3!4!5!6!7!8!9!10!11!12!13!14!15!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!";
        Node head = reconByLevelString(levelStr);
        morris(head);
        morrisPre(head);
        morrisIn(head);
        morrisPost(head);


    }


}
