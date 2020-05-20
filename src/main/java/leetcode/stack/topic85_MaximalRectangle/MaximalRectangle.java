package leetcode.stack.topic85_MaximalRectangle;

import java.util.Stack;

/**
 * @program: CodingInterviewGuide
 * @description: 85. 最大矩形
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 17:02
 **/

public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] heights = new int[matrix[0].length];

        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0;j < matrix[0].length;j++){
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }


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

        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };

        System.out.println(maximalRectangle(matrix));

    }


}
