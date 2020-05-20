package leetcode.heap.topic295_MedianFinder;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: CodingInterviewGuide
 * @description: 295. 数据流的中位数
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 21:57
 **/

public class MedianFinder {

    /**
     * 大根堆，放较小的一半数
     */
    private PriorityQueue<Integer> bigHeap;

    /**
     * 小根堆，放较大的一半数
     */
    private PriorityQueue<Integer> smallHeap;

    /**
     * 总个数
     */
    private int count = 0;


    public MedianFinder() {

        bigHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        smallHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }


    /**
     *
     * 是否可以优化平衡的调整
     *
     * @param num
     */
    public void addNum(int num) {
        bigHeap.offer(num);
        smallHeap.offer(bigHeap.poll());
        if (smallHeap.size() - bigHeap.size() > 1) {
            bigHeap.offer(smallHeap.poll());
        }
        count++;
    }

    public double findMedian() {
        if (count == 0){
            return 0;
        }

        if (count % 2 == 0) {
            // 偶数个
            return ((double)bigHeap.peek() + (double)smallHeap.peek()) / 2;
        }else {
            // 奇数个
            return bigHeap.size() > smallHeap.size() ? bigHeap.peek() : smallHeap.peek();
        }
    }


    public static void main(String[] args) {

        MedianFinder finder = new MedianFinder();

        int[] nums = new int[]{
                1,2,3,4,5,6,7,8,9,10
        };

        for (int num :nums){
            finder.addNum(num);
            System.out.println("m:"+finder.findMedian());
        }

    }


}
