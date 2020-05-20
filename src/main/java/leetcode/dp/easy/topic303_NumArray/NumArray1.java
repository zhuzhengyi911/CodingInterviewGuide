package leetcode.dp.easy.topic303_NumArray;

import java.util.HashMap;

/**
 * @program: CodingInterviewGuide
 * @description: 303. 区域和检索 - 数组不可变
 * @author: Zhu Zheng-yi
 * @create: 2020-05-08 16:27
 **/

public class NumArray1 {

    private final int[] nums;

    private HashMap<String,Integer> cache;


    public NumArray1(int[] nums) {
        this.nums = nums;
        this.cache = new HashMap<>();
    }

    /**
     * 缓存法
     *
     *
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        int sum = 0;
        String key = String.valueOf(i) + "_" + String.valueOf(j);
        if (cache.containsKey(key)){
            return cache.get(key);
        }else {
            for (int k = i; k <= j;k++){
                sum += nums[k];
            }
            cache.put(key, sum);
        }
        return sum;
    }


    public static void main(String[] args) {
        NumArray1 array = new NumArray1(new int[]{1,2,3,4,5,6});
        System.out.println(array.sumRange(1,4 ));
    }


}
