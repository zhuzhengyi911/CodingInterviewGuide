package book.chapter2_LinkedList.topic15_Convert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: CodingInterviewGuide
 * @description: 二叉搜索树转换为有序的双向链表
 * @author: Zhu Zheng-yi
 * @create: 2020-05-19 18:27
 **/

public class Convert {


    /**
     * 队列存储中序遍历
     *
     * @param root
     * @return
     */
    public static TreeNode convert1(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        inOrderToQueue(root,queue);


        root = queue.poll();
        root.left = null;

        TreeNode pre = root;
        TreeNode p = null;


        while (!queue.isEmpty()){
            p = queue.poll();
            pre.right = p;
            p.left = pre;
            pre = p;
        }
        p.right = null;

        return root;
    }

    public static void inOrderToQueue(TreeNode root, Queue<TreeNode> queue) {
        if (root==null){
            return;
        }
        inOrderToQueue(root.left, queue);
        queue.offer(root);
        inOrderToQueue(root.right,queue );
    }


    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static TreeNode convert2(TreeNode root) {
        if (root == null) {
            return null;
        }
        return process(root).start;
    }

    public static class ReturnType {
        TreeNode start;
        TreeNode end;

        public ReturnType(TreeNode start, TreeNode end) {
            this.start = start;
            this.end = end;
        }
    }

    public static ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(null, null);
        }

        ReturnType leftRes = process(root.left);
        ReturnType rightRes = process(root.right);

        ReturnType res = new ReturnType(null, null);

        if (leftRes.end != null) {
            leftRes.end.right = root;
        }
        root.left = leftRes.end;

        if (rightRes.start != null) {
            rightRes.start.left = root;
        }
        root.right = rightRes.start;

        return new ReturnType(
                leftRes.start != null ? leftRes.start : root,
                rightRes.end != null ? rightRes.end : root);
    }


    /**
     * for test
     *
     * @param levelStr
     * @return
     */
    public static TreeNode reconByLevelString(String levelStr) {

        String[] values = levelStr.split("!");

        int index = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = generateNodeByString(values[index++]);

        if (head != null) {
            queue.offer(head);
        }

        TreeNode node;

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

    private static TreeNode generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

    private static void print(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String levelStr = "6!4!7!2!5!#!9!1!3!#!#!8!#!#!#!#!#!#!#!";
        TreeNode head = reconByLevelString(levelStr);
        head = convert1(head);
        print(head);

    }


}
