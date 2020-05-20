package leetcode.tree.topic107_LevelOrderBottom;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: CodingInterviewGuide
 * @description: 107. 二叉树的层次遍历 II
 * @author: Zhu Zheng-yi
 * @create: 2020-05-13 21:08
 **/

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> deque = new LinkedList<>();
        if (root == null){
            return (List<List<Integer>>) deque;
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
                deque.offerFirst(list);
                list = new LinkedList<>();
                last = nLast;
            }
        }
        return (List<List<Integer>>) deque;
    }

}
