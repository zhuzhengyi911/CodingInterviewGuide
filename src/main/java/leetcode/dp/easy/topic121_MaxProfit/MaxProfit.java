package leetcode.dp.easy.topic121_MaxProfit;

import java.util.Stack;

public class MaxProfit {


    /**
     * 单调栈（不算好方法）
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }


        Stack<Integer> stack = new Stack<>();
        stack.push(prices[0]);

        int profit = 0;
        int bottom = stack.peek();

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                bottom = prices[i];
            }
            stack.push(prices[i]);

            profit = Math.max(profit, stack.peek() - bottom);
        }
        return profit;
    }


    /**
     * dp，保存之前的最小值
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int preMin = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - preMin);
            preMin = Math.min(preMin, prices[i]);
        }
        return profit;
    }


    public static void main(String[] args) {
        int[] prices = new int[]{7, 2, 7, 1, 5, 4, 8, 10};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));

    }
}
