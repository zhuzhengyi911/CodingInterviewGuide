package book.chapter1_StackAndQueue.topic10_GetNum;

import java.util.LinkedList;

/**
 * tip: i++的位置
 */
public class MyGetNum {

    public static Integer getNum(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return null;
        }

        int res = 0;

        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();

        int i = 0;
        int j = 0;

        while (i < arr.length) {

            while (j < arr.length) {
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollFirst();
                }
                qmax.addLast(j);
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);

                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }

                j++;
            }

            res += j - i;

            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            i++;
        }

        return res;
    }

    public static int right(int[] arr, int num) {
        int res = 0;

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int k = start; k <= end; k++) {
                    max = Math.max(max, arr[k]);
                    min = Math.min(min, arr[k]);
                }

                if (max - min <= num) {
                    res++;
                }
            }


        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 5, 6, 9};
        int num = 2;

        int res1 = right(arr, num);
        System.out.println(res1);
        int res2 = getNum(arr, num);
        System.out.println(res2);
        if (right(arr, num) == getNum(arr, num)) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }


    }
}
