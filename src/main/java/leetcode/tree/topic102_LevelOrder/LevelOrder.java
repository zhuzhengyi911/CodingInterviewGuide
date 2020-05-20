package leetcode.tree.topic102_LevelOrder;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: CodingInterviewGuide
 * @description: 102. 二叉树的层序遍历
 * @author: Zhu Zheng-yi
 * @create: 2020-05-13 20:59
 **/

public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null){
            return lists;
        }



        TreeNode last = root;
        TreeNode nLast = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> list = new LinkedList<>();

        while (!queue.isEmpty()){
            root = queue.poll();
            list.add(root.val);

            if (root.left != null){
                queue.offer(root.left);
                nLast = root.left;
            }

            if (root.right != null){
                queue.offer(root.right);
                nLast = root.right;
            }

            if (root == last){
                lists.add(list);
                list = new LinkedList<>();
                last = nLast;
            }
        }
        return lists;
    }

}
