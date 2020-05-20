package book.chapter3_Tree.topic4_Serial;

import com.sun.xml.internal.fastinfoset.algorithm.HexadecimalEncodingAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 二叉树的序列化和反序列化
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 15:43
 **/

public class Serial {


    public static String serialByPre(Node head){
        if (head == null){
            return "#!";
        }

        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
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


    public static String serialByLevel(Node head){
        if (head == null){
            return "#!";
        }

        String res = head.val + "!";

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()){
            head = queue.poll();

            if (head.left != null){
                res += head.left.val + "!";
                queue.offer(head.left);
            }else {
                res += "#!";
            }

            if (head.right != null){
                res += head.right.val + "!";
                queue.offer(head.right);
            }else {
                res += "#!";
            }

        }
        return res;
    }


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


        /**
         * 先序
         */
        String preStr = "1!2!#!4!7!#!#!8!#!11!13!#!#!14!#!#!3!5!9!12!15!#!#!16!#!#!#!10!#!#!6!#!#!";
        Node head = reconByPreString(preStr);
        Stack<Node> stack = new Stack<>();
        Node p = head;
        stack.push(p);
        while (!stack.isEmpty()){
            p = stack.pop();

            System.out.print(p.val + " ");

            if (p.right != null){
                stack.push(p.right);
            }

            if (p.left != null){
                stack.push(p.left);
            }
        }
        System.out.println();







        /**
         * 层序
         */
        String levelStr = serialByLevel(head);
        System.out.println(levelStr);

        head = reconByLevelString(levelStr);

        p = head;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(p);

        while (!queue.isEmpty()){
            p = queue.poll();

            System.out.print(p.val + " ");

            if (p.left != null){
                queue.offer(p.left);
            }

            if (p.right != null){
                queue.offer(p.right);
            }
        }
        System.out.println();




    }

}
