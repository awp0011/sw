package sw.pro.kthnumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source_my {
    private static int[] numbers = new int[5000005];
    private static int[] temp = new int[5000005];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());

        }
        mergeSort(0, N - 1);
        System.out.println(numbers[K - 1]);
    }

    private static void mergeArray(int first, int mid, int last) {
        int i = first, j = mid + 1;
        int k = 0;

        while (i <= mid && j <= last) {
            if (numbers[i] <= numbers[j])
                temp[k++] = numbers[i++];
            else
                temp[k++] = numbers[j++];
        }

        while (i <= mid)
            temp[k++] = numbers[i++];

        while (j <= last)
            temp[k++] = numbers[j++];

        for (i = 0; i < k; i++)
            numbers[first + i] = temp[i];
    }

    private static void mergeSort(int first, int last) {
        if (first < last) {
            int mid = (first + last) >> 1;
            mergeSort(first, mid);
            mergeSort(mid + 1, last);
            mergeArray(first, mid, last);
        }
    }

}
