package book.chapter1_StackAndQueue.topic9_MaxRec;


import java.util.Stack;

public class Solution {

    public int maxRecSize(int[][] map) {
        int maxArea = 0;
        if (map == null || map.length == 0 || map[0].length == 0) {
            return maxArea;
        }

        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 1 ? height[j] + 1 : 0;
            }
            // a >= b ? a : b
            maxArea = Math.max(maxSizeRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    private int maxSizeRecFromBottom(int[] height) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea,curArea);
        }

        return maxArea;
    }


    public static void main(String[] args) {
        int[][] map = {{1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}};

        System.out.println("maxArea:"+new Solution().maxRecSize(map));


    }

}
