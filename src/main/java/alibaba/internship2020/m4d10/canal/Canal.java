package alibaba.internship2020.m4d10.canal;

public class Canal {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 4, 100};


        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i <= 100; i++) {

            int sum = 0;
            for (int j = 0;j < arr.length;j++){
                sum += Math.abs(arr[j] - i);
            }

            if (sum < min){
                min = sum;
                index = i;
            }

        }

        System.out.println("index:"+index);
        System.out.println("sum:"+min);



    }


}
