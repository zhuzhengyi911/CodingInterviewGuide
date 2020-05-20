package leetcode.dp.middle.topic120_MinimumTotal;

import book.chapter4_DP.topic7_Lis.Lis;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: CodingInterviewGuide
 * @description: 120. 三角形最小路径和
 * @author: Zhu Zheng-yi
 * @create: 2020-05-09 09:05
 **/

public class MinimumTotal {


    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();

        int[] preRow = new int[n];
        preRow[0] = 0;
        int i = 0;
        for (List<Integer> list : triangle) {
            int[] row = new int[i + 1];
            int j = 0;
            for (int num : list){
                if (j == 0){
                    row[j] = num + preRow[j];
                }else {
                    row[j] = num + (j == i ? preRow[j - 1]: Math.min(preRow[j - 1], preRow[j]));   // 极易出错
                }
                j++;
            }

            for (int k = 0;k < row.length;k++){
                preRow[k] = row[k];
            }
            i++;
        }

        int min = Integer.MAX_VALUE;
        for (i = 0 ; i <preRow.length;i++){
            if (preRow[i] < min){
                min = preRow[i];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();

        int[][] t = new int[][]{
                {2, -1, -1, -1},
                {3, 4, -1, -1},
                {6, 5, 7, -1},
                {4, 1, 8, 3},
        };

        for (int i = 0; i < t.length; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < t[0].length; j++) {
                if (t[i][j] > -1) {
                    list.add(t[i][j]);
                }
            }
            triangle.add(list);
        }

        System.out.println(minimumTotal(triangle));
    }
}
