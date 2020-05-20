package book.chapter1_StackAndQueue.topic7_MaxWindow;

import java.util.Arrays;
import java.util.LinkedList;

public class MyMaxWindow {


    public int[] maxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] result = new int[arr.length - w + 1];

        LinkedList<Integer> maxQueue = new LinkedList<>();

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[i]) {
                maxQueue.pollLast();
            }

            maxQueue.addLast(i);

            if (maxQueue.peekFirst() <= i - w) {
                maxQueue.pollFirst();
            }

            if (i >= w - 1) {
                result[index++] = arr[maxQueue.peekFirst()];
            }
        }

        return result;
    }


    public int[] rightway(int[] arr, int windowSize) {
        int[] result = new int[arr.length - windowSize + 1];
        for (int i = 0; i < result.length; i++) {
            int max = arr[i];
            for (int j = i + 1; j < i + 3; j++) {
                max = Math.max(max, arr[j]);
            }
            result[i] = max;
        }
        return result;
    }


    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 生成随机数组
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int minSize, int maxSize, int maxValue) {
        int[] arr = new int[(int) (minSize + Math.random() * (maxSize - minSize + 1))];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }


    /**
     * 绝对正确的参照组方法
     *
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 复制数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return arr;
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    /**
     * 判断数组是否相同
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        int testTime = 5000;
        int maxSize = 20;
        int maxValue = 20;
        int windowSize = 3;
        MyMaxWindow maxWindow = new MyMaxWindow();
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(windowSize, maxSize, maxValue);
            int[] result1 = maxWindow.rightway(arr, windowSize);
            int[] result2 = maxWindow.maxWindow(arr, windowSize);

            if (!isEqual(result1, result2)) {
                succeed = false;
                maxWindow.printArray(arr);
                maxWindow.printArray(result1);
                maxWindow.printArray(result2);
                break;
            }
        }
        System.out.println(succeed ? "pass!" : "failed!");

    }

}