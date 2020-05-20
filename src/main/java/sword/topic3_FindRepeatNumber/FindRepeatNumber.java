package sword.topic3_FindRepeatNumber;

import java.util.HashSet;

/**
 * @program: CodingInterviewGuide
 * @description:
 * @author: Zhu Zheng-yi
 * @create: 2020-05-19 20:36
 **/

public class FindRepeatNumber {


    public int findRepeatNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return 0;
    }

}
