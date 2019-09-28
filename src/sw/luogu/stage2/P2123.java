package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P2123 {
    private static final int[][] hands = new int[20005][3];

    public static void main(String[] args) throws Exception {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        long start = System.currentTimeMillis();
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 0; t < T; t++) {
            in.nextToken();
            int n = (int) in.nval;
            for (int i = 1; i <= n; i++) {
                in.nextToken();
                hands[i][0] = (int) in.nval;
                in.nextToken();
                hands[i][1] = (int) in.nval;
                if (hands[i][1] > hands[i][0]) hands[i][2] = 0;
                else hands[i][2] = 1;
            }
            Arrays.sort(hands, 1, n + 1, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] != o2[2] ? o1[2] - o2[2] :
                            o1[2] == 0 ? o1[0] - o2[0] : o2[1] - o1[1];
                }
            });
            long sum = hands[1][0];
            long max = hands[1][0] + hands[1][1];
            for (int i = 2; i <= n; i++) {
                sum += hands[i][0];
                max = Math.max(sum, max) + hands[i][1];
            }
            System.out.println(max);
        }
    }

}
