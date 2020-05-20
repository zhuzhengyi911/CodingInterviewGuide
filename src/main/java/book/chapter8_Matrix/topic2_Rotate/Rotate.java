package book.chapter8_Matrix.topic2_Rotate;

/**
 * @program: CodingInterviewGuide
 * @description: 将正方形矩阵顺时针旋转90度
 * @author: Zhu Zheng-yi
 * @create: 2020-05-12 19:30
 **/

public class Rotate {


    public static void rotate(int[][] matrix) {
        int sR = 0;
        int sC = 0;
        int eR = matrix.length - 1;
        int eC = matrix[0].length - 1;
        while (sR <= eR) {
            rotateEdge(matrix, sR++, sC++, eR--, eC--);
        }
    }

    private static void rotateEdge(int[][] matrix, int sR, int sC, int eR, int eC) {
        int times = eR - sR;
        int temp;
        for (int i = 0; i < times; i++) {
            temp = matrix[sR][sC + i];
            matrix[sR][sC + i] = matrix[eR - i][sC];
            matrix[eR - i][sC] = matrix[eR][eC - i];
            matrix[eR][eC - i] = matrix[sR + i][eC];
            matrix[sR + i][eC] = temp;
        }
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        rotate(matrix);
        printMatrix(matrix);
    }
}
