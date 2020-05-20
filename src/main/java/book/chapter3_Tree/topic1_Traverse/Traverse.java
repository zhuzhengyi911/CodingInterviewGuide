package book.chapter3_Tree.topic1_Traverse;

import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 二叉树前序中序后序遍历
 * @author: Zhu Zheng-yi
 * @create: 2020-05-11 21:07
 **/

public class Traverse {


    /**
     * 先序遍历
     *
     * @param head
     */
    public static void preOrder(Node head) {
        System.out.print("Pre-order: ");

        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();

            System.out.print(head.val + " ");
            if (head.right != null) {
                stack.push(head.right);
            }

            if (head.left != null) {
                stack.push(head.left);
            }
        }

        System.out.println();
    }


    /**
     * 中序遍历版本1
     *
     * @param head
     */
    public static void inOrder1(Node head) {
        System.out.print("In-order: ");

        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
        System.out.println();
    }


    /**
     * 中序遍历版本2
     *
     * @param head
     */
    public static void inOrder2(Node head) {
        System.out.print("In-order: ");

        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();
    }


    /**
     * 双栈实现后续遍历(先序逆序的思想)
     *
     * @param head
     */
    public static void posOrder1(Node head) {
        System.out.print("Pos-order: ");

        if (head == null){
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(head);
        while (!stack1.isEmpty()){
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null){
                stack1.push(head.left);
            }
            if (head.right!=null){
                stack1.push(head.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().val + " ");
        }
        System.out.println();
    }


    /**
     * 单栈实现后序遍历（注意if的判定条件）
     *
     * peekNode 和 popNode
     *
     * @param head
     */
    public static void posOrder2(Node head) {
        System.out.print("Pos-order: ");
        if (head == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node popNode = head;
        Node peekNode = head;
        stack.push(head);

        while (!stack.isEmpty()){
            peekNode = stack.peek();

            if (peekNode.left != null && peekNode.left != popNode && peekNode.right != popNode){
                // 左孩子
                stack.push(peekNode.left);
            }else if (peekNode.right != null && peekNode.right != popNode){
                // 右孩子
                stack.push(peekNode.right);
            }else {
                System.out.print(stack.pop().val + " ");
                popNode = peekNode;
            }
        }
        System.out.println();

    }



    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;

        preOrder(node1);
        inOrder1(node1);
        inOrder2(node1);
        posOrder1(node1);
        posOrder2(node1);
    }


}
