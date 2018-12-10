package sw.pro.NUMBEROFINVERSION;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    private static final int[][] MS = new int[2][100_003];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            MS[0][i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mergeSort(0, N));

    }


    private static long mergeSort(final int start, final int end) {
        if (end - start < 2) return 0;
        long cnt = 0;
        int mid = (start + end) >> 1;
        cnt += mergeSort(start, mid);
        cnt += mergeSort(mid, end);
        cnt += merge(start, mid, end);
        return cnt;

    }

    private static long merge(final int first, final int second, final int end) {
        long cnt = 0;
        int s1 = first;
        int s2 = second;
        int index = first;
        while (s1 < second && s2 < end) {
            if (MS[0][s1] > MS[0][s2]) {
                MS[1][index++] = MS[0][s2++];
                cnt += second - s1;
            } else {
                MS[1][index++] = MS[0][s1++];
            }
        }
        while (s1 < second) MS[1][index++] = MS[0][s1++];
        while (s2 < end) MS[1][index++] = MS[0][s2++];

        if (end - first >= 0) System.arraycopy(MS[1], first, MS[0], first, end - first);
        return cnt;
    }

}

