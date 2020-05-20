package book.chapter4_DP.topic8_Envelope;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static class Envelope {
        public int len;
        public int wid;

        Envelope(int len, int wid) {
            this.len = len;
            this.wid = wid;
        }
    }

    public static class EnvelopeCompator implements Comparator<Envelope> {
        @Override
        public int compare(Envelope o1, Envelope o2) {
            return o1.len != o2.len ? o1.len - o2.len : o2.wid - o1.wid;
        }
    }

    public static Envelope[] getSortedEnvelopes(int[][] map) {
        Envelope[] envelopes = new Envelope[map.length];
        for (int i = 0; i < map.length; i++) {
            envelopes[i] = new Envelope(map[i][0],map[i][1]);
        }
        Arrays.sort(envelopes,new EnvelopeCompator());
        return envelopes;
    }

    public static int maxEnvelopes(int[][] matrix){
        Envelope[] envelopes = getSortedEnvelopes(matrix);

        int[] ends = new int[envelopes.length];
        ends[0] = envelopes[0].wid;
        int right = 0;
        int index;
        for (int i = 1;i < envelopes.length;i++){
            index = bSearch(ends,0,right,envelopes[i].wid);
            right = Math.max(right,index);
            ends[index] = envelopes[i].wid;
        }
        return right + 1;
    }

    public static int bSearch(int[] arr, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3,4},
                {2,3},
                {4,5},
                {1,3},
                {2,2},
                {3,6},
                {1,2},
                {3,2},
                {2,4}
        };
        System.out.println(maxEnvelopes(matrix));

    }

}
