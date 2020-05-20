package leetcode.heap.topic215_FindKthLargest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: CodingInterviewGuide
 * @description: 215. 数组中的第K个最大元素
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 21:22
 **/

public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0 ;i < k;i++){
            smallHeap.offer(nums[i]);
        }

        for (int i = k ; i < nums.length;i++){
            if (nums[i] > smallHeap.peek()){
                smallHeap.poll();
                smallHeap.offer(nums[i]);
            }
        }
        return smallHeap.poll();
    }


    public static void main(String[] args) {


        int[] nums = new int[]{
                3, 2, 1, 5, 6, 4
        };
        int k = 2;

        System.out.println(findKthLargest(nums,k ));


    }


}
