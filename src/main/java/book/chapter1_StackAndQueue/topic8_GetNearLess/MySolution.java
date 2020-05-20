package book.chapter1_StackAndQueue.topic8_GetNearLess;


import java.util.Stack;


/**
 * 分类：单调栈
 *
 * tip：getNearLess 和 getNearLessNoRepeat 都不需要增加List结构
 */
public class MySolution {


    /**
     * 暴力方法，作为対数器
     *
     * @param arr
     * @return
     */
    public int[][] rightWay(int[] arr) {
        int[][] result = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {

            int j = i - 1;
            while (j > -1) {
                if (arr[j] < arr[i]) {
                    result[i][0] = j;
                    break;
                }
                j--;
            }
            if (j == -1) {
                result[i][0] = -1;
            }

            j = i + 1;
            while (j < arr.length) {
                if (arr[j] < arr[i]) {
                    result[i][1] = j;
                    break;
                }
                j++;
            }
            if (j == arr.length) {
                result[i][1] = -1;
            }
        }

        return result;
    }

    public int[][] getNearLess(int[] arr) {
        int[][] result = new int[arr.length][2];

        // 单调增栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int leftLess = -1;
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if (!stack.isEmpty()){
                leftLess = stack.peek();
            }
            stack.push(i);
            result[i][0] = leftLess;
        }

        stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0 ; i--) {
            int rightLess = -1;
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if (!stack.isEmpty()){
                rightLess = stack.peek();
            }
            stack.push(i);
            result[i][1] = rightLess;
        }

        return result;
    }


    // 以下为対数器

    /**
     * 生成随机数组
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize - 1))];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * 复制数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return arr;
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    /**
     * 判断数组是否相同
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[][] arr1, int[][] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0;i<arr1.length;i++){
            for (int j = 0;j < arr1[0].length;j++){
                if (arr1[i][j] != arr2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }



    public void printResult(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println("{" + result[i][0] + "," + result[i][1] + "}");
        }
    }


    public void printError(int[] arr,int[][] result1,int[][] result2){
        System.out.println("target arr:");
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("right way:");
        printResult(result1);
        System.out.println("result:");
        printResult(result2);
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 20;
        int maxValue = 10;
        boolean succeed = true;

        MySolution test = new MySolution();

        for (int i = 0; i < testTime; i++) {
            int[] arr =generateRandomArray(maxSize, maxValue);

            int[][] result1 = test.rightWay(arr);
            int[][] result2 = test.getNearLess(arr);

            if (!isEqual(result1, result2)) {
                succeed = false;
                test.printError(arr,result1,result2);
                break;
            }
        }
        System.out.println(succeed ? "pass!" : "failed!");

    }





}
