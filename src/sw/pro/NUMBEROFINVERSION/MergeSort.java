package sw.pro.NUMBEROFINVERSION;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MergeSort {
    private static final int[] temp = new int[100_003];
    private static final int[] array = new int[100_003];
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mergeSort(0, N - 1));

    }

    private static int mergeSort(final int left, final int right) {
        int cnt = 0;
        if (left == right) {
            temp[left] = array[left];
        } else {
            int m = (left + right) >> 1;

            int l = left;
            int r = m;
            int index = left;
            if (right - left > 1) {
                cnt += mergeSort(left, m - 1);
                cnt += mergeSort(m, right);
            } else if (right - left == 1) {
                r = right;
                m=right;
            }

            while (l <= m-1 && r <= right) {
                if (array[l] > array[r]) {
                    temp[index] = array[r];
                    r++;
                    cnt += m - l ;
                } else {
                    temp[index] = array[l];
                    l++;
                }
                index++;
            }
            while (l <= m-1) {
                temp[index] = array[l];
                l++;
                index++;
            }
            while (r <= right) {
                temp[index] = array[r];
                r++;
                index++;
            }
        }
        if (right == N - 1) {
            System.arraycopy(temp, 0, array, 0, N);
        }
        return cnt;
    }
}
