package sw.pro.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MergeSort {



    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] output = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                output[k++] = left[i++];
            } else {
                output[k++] = right[j++];
            }
        }
        while (i < left.length) {
            output[k++] = left[i++];
        }
        while (j < right.length) {
            output[k++] = right[j++];
        }
        return output;
    }
    private static int[] intArray = new int[5_000_005];
    private static int[] temp = new int[5_000_005];
    public static void main(String args[]) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            intArray[i] = Integer.valueOf(br.readLine());
        }
         mergeSort(0,N);
        System.out.println(intArray[K-1]);
    }

    private static int[] mergeSort(final int start,final int end) {

        return new int[]{1,2,3};// merge(mergeSort(left), mergeSort(right));
    }
}
