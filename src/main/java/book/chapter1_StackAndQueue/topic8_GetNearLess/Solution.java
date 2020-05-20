package book.chapter1_StackAndQueue.topic8_GetNearLess;

import java.util.Stack;

public class Solution {
    /**
     * 简单左右遍历，时间复杂度为O（N2）
     *
     * @param arr
     * @return
     */
    public int[][] rightWay(int[] arr) {
        int[][] result = new int[arr.length][2];
        int leftLessIndex, rightLessIndex, currentIndex;
        for (int i = 0; i < arr.length; i++) {
            leftLessIndex = -1;
            rightLessIndex = -1;
            currentIndex = i - 1;
            while (currentIndex > -1) {
                if (arr[currentIndex] < arr[i]) {
                    leftLessIndex = currentIndex;
                    break;
                }
                currentIndex--;
            }
            currentIndex = i + 1;
            while (currentIndex < arr.length) {
                if (arr[currentIndex] < arr[i]) {
                    rightLessIndex = currentIndex;
                    break;
                }
                currentIndex++;
            }
            result[i][0] = leftLessIndex;
            result[i][1] = rightLessIndex;
        }
        return result;
    }

    public int[][] getNearLessNoRepeat(int[] arr) {
        int[][] result = new int[arr.length][2];

        int lessIndex;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            lessIndex = -1;
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                lessIndex = stack.peek();
            }
            stack.push(i);
            result[i][0] = lessIndex;
        }

        stack = new Stack<>();
        for (int i = arr.length - 1; i > -1; i--) {
            lessIndex = -1;
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                lessIndex = stack.peek();
            }
            stack.push(i);
            result[i][1] = lessIndex;
        }
        return result;
    }

    public int[][] getNearLess(int[] arr) {
        int[][] result = new int[arr.length][2];

        int lessIndex;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            lessIndex = -1;
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                lessIndex = stack.peek();
            }
            stack.push(i);
            result[i][0] = lessIndex;
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 1, 3, 4, 3, 5, 3, 2, 2};
        int[] arr = {3, 4, 4, 1, 6, 2, 7};
        int[][] result = new Solution().getNearLessNoRepeat(arr);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
