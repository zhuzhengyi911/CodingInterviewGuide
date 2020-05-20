package leetcode.tree.topic94_inorderTraversal;


import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 94. 二叉树的中序遍历
 * @author: Zhu Zheng-yi
 * @create: 2020-05-11 16:21
 **/

public class InorderTraversal {


    /**
     *
     * 递归版本
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        traverse1(root, result);
        return result;
    }

    private static void traverse1(TreeNode curr,List<Integer> result ){

        if (curr.left != null){
            traverse1(curr.left, result);
        }

        result.add(curr.val);

        if (curr.right != null){
            traverse1(curr.right, result);
        }
    }


    /**
     *
     * 迭代版本
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        TreeNode curr = root;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (curr != null || !stack.isEmpty()){

            while (curr.left != null){
                stack.push(curr.left);
                curr = curr.left;
            }


            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;



        }

        return result;
    }




    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;

        for (Integer x : inorderTraversal1(node1) ){
            System.out.print(x+ " ");
        }





    }






}
