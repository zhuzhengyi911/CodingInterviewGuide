package leetcode.tree.topic637_AverageOfLevels;

import book.chapter4_DP.topic7_Lis.Lis;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: CodingInterviewGuide
 * @description: 637. 二叉树的层平均值
 * @author: Zhu Zheng-yi
 * @create: 2020-05-13 21:13
 **/

public class AverageOfLevels {



    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new LinkedList<>();
        if (root == null){
            return averages;
        }

        double sum = 0;
        double count = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = root;
        TreeNode nLast = null;

        queue.offer(root);

        while (!queue.isEmpty()){
            root = queue.poll();
            sum += root.val;
            count = count + 1;

            if (root.left != null){
                queue.offer(root.left);
                nLast = root.left;
            }

            if (root.right != null){
                queue.offer(root.right);
                nLast = root.right;
            }

            if (last == root){
                averages.add(sum/count);
                sum = 0;
                count = 0;
                last = nLast;
            }
        }
        return averages;
    }




}
