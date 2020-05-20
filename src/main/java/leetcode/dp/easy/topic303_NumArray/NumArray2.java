package leetcode.dp.easy.topic303_NumArray;

/**
 * @program: CodingInterviewGuide
 * @description: 303. 区域和检索 - 数组不可变
 * @author: Zhu Zheng-yi
 * @create: 2020-05-08 16:42
 **/

public class NumArray2 {

    private int[] sum;


    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

    }

    /**
     * DP
     *
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }


    public static void main(String[] args) {
        NumArray2 array = new NumArray2(new int[]{-2,-3,0,9});
        System.out.println(array.sumRange(0, 2));
    }


}
