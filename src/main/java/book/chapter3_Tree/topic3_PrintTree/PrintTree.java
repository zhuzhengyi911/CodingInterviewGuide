package book.chapter3_Tree.topic3_PrintTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: CodingInterviewGuide
 * @description: 直观打印一棵树
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 17:17
 **/

public class PrintTree {

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head,0,"H" , 17 );
        System.out.println();
    }

    private static void printInOrder(Node head, int height, String to, int len) {
        if (head == null){
            return;
        }

        printInOrder(head.right,height +1 ,"v" , 17);

        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenL - lenM;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);

        printInOrder(head.left,height +1 ,"^" , 17);


    }


    private static String getSpace(int num){
        String space = " ";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i< num;i++){
            builder.append(space);
        }
        return builder.toString();
    }


    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();

        for (String s : values){
            queue.offer(s);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }

        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }


    public static void main(String[] args) {
        String preStr = "1!2!#!4!7!#!#!8!#!11!13!#!#!14!#!#!3!5!9!12!15!#!#!16!#!#!#!10!#!#!6!#!#!";
        Node head = reconByPreString(preStr);
        printTree(head);

    }




}
