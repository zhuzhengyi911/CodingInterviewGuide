package guidance.junior.class_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 寻找连个有序数组A,B,两者不重复的部分
 * <p>
 * 一个有序数组A，另一个无序数组B，请打印B中的所有不在A中的数，A数组长度为N，B数组长度为M。
 * <p>
 * 算法流程1：对于数组B中的每一个数，都在A中通过遍历的方式找一下；
 * 算法流程2：对于数组B中的每一个数，都在A中通过二分的方式找一下；
 * 算法流程3：先把数组B排序，然后用类似外排的方式打印所有在A中出现的数；
 */
public class Code_10_GetAllNotIncluded {


    /**
     * 对A使用二分查找
     *
     * @param A
     * @param B
     * @return
     */
    public static List<Integer> getAllNotIncluded(int[] A, int[] B) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            // 二分查找
            int l = 0;
            int r = A.length - 1;
            boolean contains = false;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (A[mid] == B[i]) {
                    contains = true;
                    break;
                } else if (A[mid] > B[i]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (!contains) {
                res.add(B[i]);
            }
        }
        return res;
    }


    public static List<Integer> comparator(int[] A, int[] B) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            boolean contains = false;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == B[i]) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                res.add(B[i]);
            }
        }

        return res;
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static boolean isEqual(List<Integer> l1, List<Integer> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : l1) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
        }

        for (Integer i : l2) {
            if (!map.containsKey(i)) {
                return false;
            }
            map.put(i, map.get(i) - 1);
            if (map.get(i) < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int testTime = 300000;
        int sortedArrayMaxSize = 300;
        int unsortedArrayMaxSize = 10;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] A = generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] B = generateRandomArray(unsortedArrayMaxSize, maxValue);
            Arrays.sort(A);
            List<Integer> res1 = getAllNotIncluded(A, B);
            List<Integer> res2 = comparator(A, B);
            if (!isEqual(res1, res2)) {
                succeed = false;
                System.out.println(res1);
                System.out.println(res2);
                break;
            }

        }
        System.out.println(succeed ? "pass!" : "failed!");


    }


}
