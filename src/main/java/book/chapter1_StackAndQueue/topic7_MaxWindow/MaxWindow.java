package book.chapter1_StackAndQueue.topic7_MaxWindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaxWindow {

    public int[] getMaxWindow(int[] array, int windowSize) {
        int len = array.length;
        int[] result = new int[len];
        Deque<Integer> maxQueue = new LinkedList<>();
        int i = 0;
        int j;
        int k = 0;

        while (i < len) {
            if (maxQueue.isEmpty()) {
                maxQueue.offer(i);
                i++;
                result[k++] = array[maxQueue.peek()];
            } else {

                j = maxQueue.peekLast();
                if (array[j] > array[i]) {
                    maxQueue.offer(i);

                    while (maxQueue.peek() <= i - windowSize) {
                        maxQueue.poll();
                    }

                    result[k++] = array[maxQueue.peek()];
                    i++;
                } else {
                    maxQueue.pollLast();
                }
            }
        }
        return result;
    }


    public int[] getMaxWindow2(int[] array, int windowSize) {
        int[] result = new int[array.length - windowSize + 1];
        int index = 0;
        Deque<Integer> maxQueue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {

            while (!maxQueue.isEmpty() && array[maxQueue.peekLast()] <= array[i]){
                maxQueue.pollLast();
            }
            maxQueue.offerLast(i);

            if (maxQueue.peekFirst() == i-windowSize){
                maxQueue.pollFirst();
            }

            if (i > windowSize - 2){
                result[index++] = array[maxQueue.peekFirst()];
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] array = {4, 3, 5, 4, 3, 3, 6, 7};
        int windowSize = 3;
        int[] result = new MaxWindow().getMaxWindow2(array, windowSize);
        System.out.println();
        for (int max : result) {
            System.out.print(max + "  ");
        }
    }
}
