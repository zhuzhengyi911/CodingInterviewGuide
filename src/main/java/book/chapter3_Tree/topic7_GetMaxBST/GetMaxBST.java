package book.chapter3_Tree.topic7_GetMaxBST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: CodingInterviewGuide
 * @description: 找到二叉树中最大的二叉搜索子树
 * @author: Zhu Zheng-yi
 * @create: 2020-05-13 19:51
 **/

public class GetMaxBST {


    public static Node getMaxBST(Node head) {
        return process(head).maxBSTHead;
    }


    private static ReturnType process(Node p) {
        if (p == null) {
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        ReturnType lResult = process(p.left);
        ReturnType rResult = process(p.right);


        int min = Math.min(p.val, Math.min(lResult.min, rResult.min));
        int max = Math.max(p.val, Math.max(lResult.max, rResult.max));
        int maxBSTSize = Math.max(lResult.maxBSTSize, rResult.maxBSTSize);

        Node maxBSTHead = lResult.maxBSTSize >= rResult.maxBSTSize ? lResult.maxBSTHead : rResult.maxBSTHead;

        if (p.left == lResult.maxBSTHead && p.right == rResult.maxBSTHead && p.val > lResult.max && p.val < rResult.min) {
            maxBSTSize = lResult.maxBSTSize + rResult.maxBSTSize + 1;
            maxBSTHead = p;
        }

        return new ReturnType(maxBSTHead,maxBSTSize ,min ,max );


    }


    public static class ReturnType {
        Node maxBSTHead;
        int maxBSTSize;
        int min;
        int max;

        public ReturnType(Node maxBSTHead, int maxBSTSize, int min, int max) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.min = min;
            this.max = max;
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
        String levelStr = "6!1!12!0!3!10!13!#!#!#!#!4!14!20!16!2!5!11!15!#!#!#!#!#!#!#!#!#!#!#!#!";
        Node head = reconByLevelString(levelStr);
        Node maxBSTHead = getMaxBST(head);

        System.out.println(maxBSTHead.val);

    }


}
