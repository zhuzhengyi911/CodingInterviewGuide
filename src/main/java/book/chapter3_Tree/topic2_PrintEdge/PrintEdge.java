package book.chapter3_Tree.topic2_PrintEdge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: CodingInterviewGuide
 * @description: 打印二叉树的边界节点
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 15:40
 **/

public class PrintEdge {


    /**
     * 标准1
     *
     * @param head
     */
    public static void printEdge1(Node head) {
        if (head == null) {
            return;
        }

        int height = getHeight(head, 0);
        Node[][] map = new Node[height][2];
        setMap(head, 0, map);

        // 先正序打印map[i][0]
        for (int i = 0; i < map.length; i++) {
            System.out.print(map[i][0].val + " ");
        }

        // 打印不在map中的叶子节点

        printLeafNotInMap(head, 0, map);

        // 反序打印map[i][1]
        for (int i = map.length - 1; i > 0; i--) {
            System.out.print(map[i][1].val + " ");
        }
        System.out.println();

    }


    private static int getHeight(Node head, int l) {
        if (head == null) {
            return l;
        }
        return Math.max(getHeight(head.left, l + 1), getHeight(head.right, l + 1));
    }

    /**
     * 先序遍历
     *
     * @param head
     * @param map
     */
    private static void setMap(Node head, int l, Node[][] map) {
        if (head == null) {
            return;
        }

        if (map[l][0] == null) {
            map[l][0] = head;
        }
        map[l][1] = head;

        setMap(head.left, l + 1, map);
        setMap(head.right, l + 1, map);
    }


    private static void printLeafNotInMap(Node head, int l, Node[][] map) {
        if (head == null) {
            return;
        }

        if (head.left == null && head.right == null && head != map[l][0] && head != map[l][1]) {
            System.out.print(head.val + " ");
        }

        printLeafNotInMap(head.left, l + 1, map);
        printLeafNotInMap(head.right, l + 1, map);
    }


    /**
     * 标准2
     *
     * @param head
     */
    public static void printEdge2(Node head) {
        if (head == null) {
            return;
        }

        System.out.print(head.val + " ");

        if (head.left != null && head.right != null) {
            printLeftEdge(head.left, true);
            printRightEdge(head.right, true);
        } else {
            printEdge2(head.left != null ? head.left : head.right);
        }
        System.out.println();
    }

    private static void printLeftEdge(Node node, boolean print) {
        if (node == null) {
            return;
        }

        if (print || (node.left == null && node.right == null)) {
            System.out.print(node.val + " ");
        }

        printLeftEdge(node.left, print);
        if (node.left != null) {
            print = false;
        }
        printLeftEdge(node.right, print);
    }

    private static void printRightEdge(Node node, boolean print) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            printRightEdge(node.left, false);
        }else {
            printRightEdge(node.left, true);
        }
        printRightEdge(node.right, print);

        if (print || (node.left == null && node.right == null)) {
            System.out.print(node.val + " ");
        }
    }


    /**
     * for test
     *
     * @param levelStr
     * @return
     */
    public static Node reconByLevelString(String levelStr) {

        String[] values = levelStr.split("!");

        int index = 0;

        Queue<Node> queue = new LinkedList<>();
        Node head = generateNodeByString(values[index++]);

        if (head != null) {
            queue.offer(head);
        }

        Node node;

        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }


        }

        return head;
    }

    private static Node generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }

    public static void main(String[] args) {
        String levelStr = "1!2!3!#!4!5!6!7!8!9!10!#!#!#!#!#!11!12!#!#!#!13!14!15!16!#!#!#!#!#!#!#!#!";
        Node head = reconByLevelString(levelStr);
        System.out.println("标准1打印：");
        printEdge1(head);
        System.out.println("标准2打印：");
        printEdge2(head);

    }


}
