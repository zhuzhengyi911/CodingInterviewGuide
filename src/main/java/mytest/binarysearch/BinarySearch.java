package mytest.binarysearch;

import java.util.Random;

/**
 * @program: CodingInterviewGuide
 * @description: 二分搜索
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 21:12
 **/

public class BinarySearch {


    /**
     * 查找第一个大于或等于k的数的下标
     */
    public static int right1(int[] nums, int k) {
        int index = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int binarySearch1(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] < k){
                l = m + 1;
            }else {
                r = m -1;
            }
        }
        return l;
    }


    public static int[] createIncreasingArray(int maxSize, int min, int maxStep) {
        int size = (int) (Math.random() * maxSize) + 1;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = min + (int) (Math.random() * (maxStep + 1));
            min = nums[i];
        }
        return nums;
    }


    public static void main(String[] args) {


        for (int i = 0; i < 20; i++) {
            int[] nums = createIncreasingArray(20, 1, 2);
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
            int k = 10;
            int index1 = right1(nums, k);
            int index2 = binarySearch1(nums, k);
            System.out.println("index: " + index1 + "  "+index2);
        }

    }


}
