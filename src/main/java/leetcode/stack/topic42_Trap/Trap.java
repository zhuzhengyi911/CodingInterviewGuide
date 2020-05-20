package leetcode.stack.topic42_Trap;

import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 42. 接雨水
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 14:41
 **/

public class Trap {

    /**
     * 单调栈
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * <p>
     * 需要两次遍历数组
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int firstMaxIndex = 0;
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                firstMaxIndex = i;
            }
        }

        int water = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < firstMaxIndex; i++) {
            if (height[i] > stack.peek()) {
                stack.push(height[i]);
            } else {
                water += stack.peek() - height[i];
            }
        }

        stack = new Stack<>();
        stack.push(0);
        for (int i = height.length - 1; i > firstMaxIndex; i--) {
            if (height[i] > stack.peek()) {
                stack.push(height[i]);
            } else {
                water += stack.peek() - height[i];
            }
        }
        return water;
    }

    /**
     *
     * 首尾同时扫描
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * 只扫描一次
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int water = 0;
        int l = 0;
        int r = height.length - 1;
        int lMax = height[l];
        int rMax = height[r];

        while (l <= r) {

            while (lMax <= rMax && l <= r){
                lMax = Math.max(lMax, height[l]);
                water += lMax - height[l];
                l++;
            }

            while (lMax > rMax && l <= r){
                rMax = Math.max(rMax, height[r]);
                water += rMax - height[r];
                r--;
            }
        }

        return water;
    }


    public static void main(String[] args) {
        int[] height = new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 3, 2, 1
        };
        System.out.println(trap1(height));
        System.out.println(trap2(height));
    }

}
