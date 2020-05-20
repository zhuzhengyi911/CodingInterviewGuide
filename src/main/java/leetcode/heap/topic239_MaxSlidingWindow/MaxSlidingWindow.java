package leetcode.heap.topic239_MaxSlidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: CodingInterviewGuide
 * @description: 239. 滑动窗口最大值
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 21:35
 **/

public class MaxSlidingWindow {


    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        result[0] = nums[deque.getFirst()];

        for (int i = k; i < nums.length; i++) {
            if (deque.getFirst() == i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            result[i - k + 1] = nums[deque.getFirst()];
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 3, -1, -3, 5, 3, 6, 7
        };
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        for (int max : result) {
            System.out.println(max + " ");
        }


    }


}
