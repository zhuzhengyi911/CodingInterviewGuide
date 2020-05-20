package leetcode.tree.topic513_FindBottomLeftValue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: CodingInterviewGuide
 * @description: 513. 找树左下角的值
 * @author: Zhu Zheng-yi
 * @create: 2020-05-13 21:20
 **/

public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null){
            return 0;
        }

        int result = 0;

        TreeNode last = root;
        TreeNode nLast = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            root = queue.poll();

            if (root.right != null){
                queue.offer(root.right);
                nLast = root.right;
            }

            if (root.left != null){
                queue.offer(root.left);
                nLast = root.left;
            }

            if (root == last){
                result = root.val;
                last = nLast;
            }
        }
        return result;
    }


}
