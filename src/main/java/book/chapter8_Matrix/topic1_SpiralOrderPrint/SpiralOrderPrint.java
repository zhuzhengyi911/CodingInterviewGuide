package book.chapter8_Matrix.topic1_SpiralOrderPrint;

/**
 * @program: CodingInterviewGuide
 * @description: 转圈打印矩阵
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 19:14
 **/

public class SpiralOrderPrint {

    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        while (tC <= dC){
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {

        if (tR == dR) {
            // 只有一行
            for (int j = tC; j <= dC; j++) {
                System.out.print(matrix[tR][j] +" ");
            }
        } else if (tC == dC) {
            // 只有一列
            for (int i = tR; i <= dR; i++) {
                System.out.print(matrix[i][tC] + " ");
            }
        }else {
            int i = tR;
            int j = tC;

            while (j != dC){
                System.out.print(matrix[i][j++] + " ");
            }
            while (i != dR){
                System.out.print(matrix[i++][j] + " ");
            }
            while (j != tC){
                System.out.print(matrix[i][j--] + " ");
            }
            while (i != tR){
                System.out.print(matrix[i--][j] + " ");
            }
        }
    }


    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        spiralOrderPrint(matrix);

    }


}
