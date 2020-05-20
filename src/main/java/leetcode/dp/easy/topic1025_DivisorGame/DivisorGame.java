package leetcode.dp.easy.topic1025_DivisorGame;

/**
 * @program: CodingInterviewGuide
 * @description: 1025. 除数博弈
 * @author: Zhu Zheng-yi
 * @create: 2020-05-08 19:00
 **/

public class DivisorGame {

    public static boolean divisorGame1(int N) {
        return N%2 ==0;
    }

    public static void main(String[] args) {
        for (int i = 2;i < 11;i++){
            System.out.println("i:"+i+"  out:"+divisorGame1(i));
        }
    }

}
