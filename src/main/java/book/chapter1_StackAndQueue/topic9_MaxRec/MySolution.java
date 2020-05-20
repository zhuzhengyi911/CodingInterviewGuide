package book.chapter1_StackAndQueue.topic9_MaxRec;

import java.util.Stack;

/**
 * 分类：单调栈
 *
 *
 * 单调栈的题目，一定要先理清思路。
 * <p>
 * tip:    k,j,i分别代表什么？   单调栈是升序还是降序？
 */
public class MySolution {


    public int maxRecSize(int[][] map) {
        int maxSize = 0;
        if (map == null) {
            return maxSize;
        }

        int[] high = new int[map[0].length];
        for (int i = 0; i < high.length; i++) {
            high[i] = 0;
        }

        for (int i = 0;i < map.length;i++){
            for (int j = 0;j<map[0].length;j++){
                if (map[i][j] == 0){
                    high[j] = 0;
                }else {
                    high[j] += map[i][j];
                }
            }
            maxSize = Math.max(maxSize,maxRecFromBottom(high));
        }
        return maxSize;
    }

    private int maxRecFromBottom(int[] high){
        int maxSize = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0;i < high.length;i++){
            // 单调增的栈
            while (!stack.isEmpty() && high[stack.peek()] >= high[i]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int size = high[j] * (i - k - 1);
                maxSize = Math.max(maxSize,size);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int size = high[j] * (high.length - k - 1);
            maxSize = Math.max(maxSize,size);
        }

        return maxSize;
    }


    public static void main(String[] args) {
        int[][] map = new int[][]{
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}
        };

        MySolution solution = new MySolution();

        int result = solution.maxRecSize(map);

        System.out.println(result);

    }
}
