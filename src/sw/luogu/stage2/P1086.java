package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P1086 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int)in.nval;
        in.nextToken();
        int m = (int)in.nval;
        in.nextToken();
        int k = (int)in.nval - 2;
        int[][] d = new int[n * m][3];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                in.nextToken();
                int next = (int)in.nval;
                if (next > 0) {
                    d[index][0] = i;
                    d[index][1] = j;
                    d[index][2] = next;
                    index++;
                }
            }
        }
        Arrays.sort(d, 0, index, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        index--;
        int ans = 0;
        int[] next = d[index];
        int[] prev = new int[]{1, next[1], 0};
        while (k > 0 && index >= 0) {
            next = d[index];
            index--;
            k -= Math.abs(prev[0] - next[0]) + Math.abs(prev[1] - next[1]);
            if (k >= next[0]) {
                ans += next[2];
                k--;
            }
            prev = next;
        }
        System.out.println(ans);
    }
}
