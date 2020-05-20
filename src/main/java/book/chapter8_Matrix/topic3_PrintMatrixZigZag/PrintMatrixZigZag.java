package book.chapter8_Matrix.topic3_PrintMatrixZigZag;

/**
 * @program: CodingInterviewGuide
 * @description: 之字形打印矩阵
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 19:48
 **/

public class PrintMatrixZigZag {

    public static void printMatrixZigZag(int[][] matrix) {
        int sR = 0;
        int sC = 0;
        int eR = 0;
        int eC = 0;

        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean goUP = true;

        while (sR != endR + 1) {
            printLevel(matrix, sR, sC, eR, eC, goUP);


            // 顺序极易出错
            sR = sC == endC ? sR + 1 : sR;
            sC = sC == endC ? sC : sC + 1;
            eC = eR == endR ? eC + 1 : eC;
            eR = eR == endR ? eR : eR + 1;
            goUP = !goUP;
        }
    }


    private static void printLevel(int[][] matrix, int sR, int sC, int eR, int eC, boolean flag) {
        if (flag) {
            // 向上
            while (eR != sR - 1) {
                System.out.print(matrix[eR--][eC++] + " ");
            }
        } else {
            // 向下
            while (sR != eR + 1) {
                System.out.print(matrix[sR++][sC--] + " ");
            }
        }
    }


    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 2, 6, 7},
                {3, 5, 8, 11},
                {4, 9, 10, 12}
        };

        printMatrixZigZag(matrix);


    }


}
