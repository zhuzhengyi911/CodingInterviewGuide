package book.chapter8_Matrix.topic4_TopK;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: CodingInterviewGuide
 * @description: Top-K问题
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 20:27
 **/

public class MinKNums {


    /**
     * 使用堆（直接用优先级度列实现）
     *
     * @param nums
     * @param k
     * @return
     */
    public static int getMinKNumsByHeap1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.poll();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 2, 5, 8, 4, 7, 6, 9
        };
        System.out.println(getMinKNumsByHeap1(nums, 2));


    }


}
