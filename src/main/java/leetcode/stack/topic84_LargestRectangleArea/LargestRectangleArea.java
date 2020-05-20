package leetcode.stack.topic84_LargestRectangleArea;

import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 84. 柱状图中最大的矩形
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 16:33
 **/

public class LargestRectangleArea {


    /**
     * 单调栈
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int l = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, height * (i - l - 1));
            }
            stack.push(i);
        }

        int r = heights.length;
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int l = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, height * (r - l - 1));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{
                2, 1, 5, 6, 2, 3
        };

        System.out.println(largestRectangleArea(heights));
    }

}
