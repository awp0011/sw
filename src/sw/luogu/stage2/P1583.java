package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P1583 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        int[][] p = new int[n + 1][2];//0:W[]; 1:ID;
        int[] E = new int[11];
        for (int i = 1; i <= 10; i++) {
            in.nextToken();
            E[i] = (int) in.nval;
        }
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            p[i][0] = (int) in.nval;
            p[i][1] = i;
        }
        Arrays.sort(p, 1, n + 1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 1; i <= n; i++) {
            p[i][0] += E[((i - 1) % 10) + 1];
        }
        Arrays.sort(p, 1, n + 1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0] == o1[0]) ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
            }
        });
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= k; i++) {
            ans.append(p[i][1]).append(' ');
        }
        System.out.println(ans.toString());
    }

}
